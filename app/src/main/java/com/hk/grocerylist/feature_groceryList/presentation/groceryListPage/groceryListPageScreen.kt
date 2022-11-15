package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.GroceryItemsEvent
import com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.groceryListPageViewModel

@Composable
fun groceryListPageScreen(
   navController: NavController,
   viewModel:groceryListPageViewModel = hiltViewModel()
) {
  val state = viewModel.state.value
  val scope = rememberCoroutineScope()

    var textForTextField by remember { mutableStateOf(TextFieldValue("")) }
    Column(
     modifier = Modifier
         .fillMaxSize()
         .padding(16.dp)

   ){
      LazyColumn(modifier = Modifier.fillMaxWidth()){
         items(state.groceryItems){groceryItem->
            GroceryItemComponent(
               groceryItem = groceryItem ,
                modifier = Modifier.fillMaxWidth(),
                onDeleteClick = {
                    viewModel.onEvent(GroceryItemsEvent.DeleteGroceryItem(groceryItem))
                }
            )

         }
      }
       //hrtr.put textField
        Box(
           modifier = Modifier.fillMaxSize()
        ){

            Row(
                modifier = Modifier.align(Alignment.BottomCenter)
            ){
                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(3f),
                )
                Button(
                    modifier = Modifier.width(88.dp),
                    onClick = {
                        viewModel.onEvent(GroceryItemsEvent.AddGroceryItem(
                            GroceryItem(
                                title = "ahahhaha"
                            )
                        ))
                        //your onclick code here
                    }) {
                    Text(text = "Button")
                }
            }
        }
//       TextField(
//           value = textForTextField,
//           singleLine = false,
//           modifier = Modifier.fillMaxWidth(),
//        onValueChange = { newText ->
//            viewModel.state.value.newString = newText.toString()
//            viewModel.onEvent(GroceryItemsEvent.TypeGroceryItem(newText.toString()))
//        }
//       )
//       TransparentHintTextField(
//           text = "",
//           hint = "hint",
//           onValueChange = {
//                          viewModel.onEvent(GroceryItemsEvent.TypeGroceryItem(it))
//           },
//           onFocusChange = {})
   }
}