package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.domain.use_case.GroceryItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class groceryListPageViewModel @Inject constructor(
    private val groceryItemUseCases: GroceryItemUseCases
): ViewModel(){

    private val _state = mutableStateOf(GroceryItemsState())

    private val _groceryItemText = mutableStateOf(GroceryItemTextFieldState(
        hint = "Enter  name of an item"
    ))
    val groceryItemText:State<GroceryItemTextFieldState> = _groceryItemText

  //just public state that UI can have access.
    val state: State<GroceryItemsState> = _state

    init{
        getGroceryItems()
    }

    fun onEvent(event:GroceryItemsEvent){
             when(event){
                 is GroceryItemsEvent.TypeGroceryItem->{
                    _groceryItemText.value =  _groceryItemText.value.copy(
                        text = event.title
                    )
                     println("debug: hey this is viewModel. I got the text.${event.title}")
                     println("debug: and now, _groceryItemText.value is ${_groceryItemText.value.text}")
                 }
                 is GroceryItemsEvent.AddGroceryItem->{

                     viewModelScope.launch {
                         //no, let;s do this. the screen will have the textField, and then onValueChange, send EnteredTitle
                         groceryItemUseCases.addGroceryItemUseCase(
                         GroceryItem(
                            title =  _groceryItemText.value.text,
                             id = itemCount
                         )
                         )
                    itemCount++;
                     }
                 }
                 is GroceryItemsEvent.DeleteGroceryItem->{
                     viewModelScope.launch {
                        groceryItemUseCases.deleteGroceryItemUseCase(event.groceryItem)
                         itemCount--;
                     }
                 }
             }
    }

    private fun getGroceryItems(){
        groceryItemUseCases.getGroceryItemsUseCase().onEach{ groceryItems->
           _state.value  = _state.value.copy(
               groceryItems = groceryItems
           )
        }.launchIn(viewModelScope)
    }

    //I want to use this as static object that can count # of items to give a new one id
    companion object{
       var itemCount:Int = 1
    }
}