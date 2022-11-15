package com.hk.grocerylist.feature_groceryList.domain.use_case

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.domain.repository.GroceryItemRepository
import kotlinx.coroutines.flow.Flow


class GetGroceryItemsUseCase (private val repository: GroceryItemRepository){

    //don't care about the order for now.
    operator fun invoke(
    ): Flow<List<GroceryItem>> {
       return repository.getGroceryItems()
    }

}