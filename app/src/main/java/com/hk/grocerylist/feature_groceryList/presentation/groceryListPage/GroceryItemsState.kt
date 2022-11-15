package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem

data class GroceryItemsState(
   val groceryItems:List<GroceryItem>  = emptyList(),
   var newString:String = "",
)
