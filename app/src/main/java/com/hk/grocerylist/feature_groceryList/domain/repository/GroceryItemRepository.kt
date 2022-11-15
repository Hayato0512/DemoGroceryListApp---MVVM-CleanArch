package com.hk.grocerylist.feature_groceryList.domain.repository

import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import kotlinx.coroutines.flow.Flow

//explain why you want to use interface here.
interface GroceryItemRepository {

    fun getGroceryItems(): Flow<List<GroceryItem>>

    suspend fun insertGroceryItem(groceryItem: GroceryItem)

    suspend fun deleteGroceryItem(groceryItem: GroceryItem)
}