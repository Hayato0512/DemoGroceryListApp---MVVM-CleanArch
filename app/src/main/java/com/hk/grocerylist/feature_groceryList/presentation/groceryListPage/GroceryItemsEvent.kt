package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem

sealed class GroceryItemsEvent {
    data class DeleteGroceryItem(val groceryItem:GroceryItem):GroceryItemsEvent()
    data class AddGroceryItem(val groceryItem:GroceryItem):GroceryItemsEvent()
    data class TypeGroceryItem(val title:String):GroceryItemsEvent()
}