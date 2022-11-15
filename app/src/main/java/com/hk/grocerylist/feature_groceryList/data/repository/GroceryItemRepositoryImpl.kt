package com.hk.grocerylist.feature_groceryList.data.repository
import com.hk.grocerylist.feature_groceryList.data.data_source.GroceryDao
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import com.hk.grocerylist.feature_groceryList.domain.repository.GroceryItemRepository
import kotlinx.coroutines.flow.Flow

class GroceryItemRepositoryImpl(
   private val dao: GroceryDao
) : GroceryItemRepository {

   override fun getGroceryItems(): Flow<List<GroceryItem>>{
      return dao.getGroceryItems()
   }

    override suspend fun insertGroceryItem(groceryItem: GroceryItem){
      return dao.insertGroceryItem(groceryItem)
    }

   override suspend fun deleteGroceryItem(groceryItem: GroceryItem){
        return dao.deleteGroceryItem(groceryItem)
       }

}