package com.hk.grocerylist.feature_groceryList.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem

@Database(
   entities = [GroceryItem::class]  ,
    version = 1
)
abstract class GroceryDataBase :RoomDatabase(){

    abstract val groceryDao:GroceryDao

    companion object{
        const val DATABASE_NAME  = "groceryItems_db"
    }

}