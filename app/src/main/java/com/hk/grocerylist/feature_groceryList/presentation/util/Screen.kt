package com.hk.grocerylist.feature_groceryList.presentation.util

sealed class Screen(val route:String){
    object groceryListPageScreen:Screen("grocery_list_page_screen")
}
