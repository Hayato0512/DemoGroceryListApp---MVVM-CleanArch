package com.hk.grocerylist.feature_groceryList.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hk.grocerylist.ui.theme.*

@Entity
data class GroceryItem (
    val title : String,

            @PrimaryKey
            val id:Int? = null,
    ){
    companion object{

        val itemColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink );
    }
}

class InvalidGroceryItemException(message: String):Exception(message)
