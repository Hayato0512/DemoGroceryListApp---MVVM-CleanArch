package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hk.grocerylist.feature_groceryList.domain.model.GroceryItem

@Composable
fun GroceryItemComponent(
   groceryItem: GroceryItem,
   modifier: Modifier = Modifier,
   onDeleteClick:()->Unit,

){
    Box(
        modifier = modifier
    ){
       Text(
          text = groceryItem.title ,
           style = MaterialTheme.typography.h6,
       maxLines =1
       )
        Spacer(modifier = Modifier.height(16.dp))
       IconButton(
          onClick = onDeleteClick ,
        modifier = Modifier.align(Alignment.BottomEnd)
       )   {
           Icon(imageVector = Icons.Default.Delete, contentDescription = "delete button")
       }


    }

}