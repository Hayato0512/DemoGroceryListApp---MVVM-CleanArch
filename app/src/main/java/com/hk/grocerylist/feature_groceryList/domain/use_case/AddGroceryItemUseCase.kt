package com.hk.grocerylist.feature_groceryList.domain.use_case

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.domain.model.InvalidGroceryItemException
import com.hk.grocerylist.feature_groceryList.domain.repository.GroceryItemRepository

class AddGroceryItemUseCase(
   private val repository:GroceryItemRepository
) {
    @Throws(InvalidGroceryItemException::class)
    suspend operator fun invoke(groceryItem: GroceryItem){
       if(groceryItem.title.isBlank()) {
          System.out.println("debug: hey the title is empty. name it stupid")
           throw InvalidGroceryItemException("debug: hey the title is empty. name it stupid")
       }
        repository.insertGroceryItem(groceryItem)
    }
}