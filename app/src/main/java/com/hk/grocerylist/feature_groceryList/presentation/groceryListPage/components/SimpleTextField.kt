package com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.GroceryItemsEvent
import com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.groceryListPageViewModel

@Composable
fun SimpleTextField(
modifier: Modifier,
viewModel: groceryListPageViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
//        onValueChange = onValueChange ,
        singleLine = false,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { newText ->
            text = newText
            viewModel.onEvent(GroceryItemsEvent.TypeGroceryItem(newText.text))
        }
    )
}

