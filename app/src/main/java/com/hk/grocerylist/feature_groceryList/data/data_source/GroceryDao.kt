package com.hk.grocerylist.feature_groceryList.data.data_source

import androidx.room.*
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem
import kotlinx.coroutines.flow.Flow


@Dao
interface GroceryDao {


   @Query("SELECT * FROM groceryItem")
    fun getGroceryItems(): Flow<List<GroceryItem>>

    //if insert the same item, then just replace.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGroceryItem(groceryItem: GroceryItem)

    @Delete
    suspend fun deleteGroceryItem(groceryItem: GroceryItem)
}