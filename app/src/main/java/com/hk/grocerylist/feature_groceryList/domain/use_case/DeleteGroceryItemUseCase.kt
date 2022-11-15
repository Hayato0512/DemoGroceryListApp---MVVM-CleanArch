package com.hk.grocerylist.feature_groceryList.domain.use_case

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.domain.repository.GroceryItemRepository

class DeleteGroceryItemUseCase(
   private val repository: GroceryItemRepository
) {



    suspend operator fun invoke(groceryItem: GroceryItem){
       repository.deleteGroceryItem(groceryItem)
    }
}