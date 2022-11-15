package com.hk.grocerylist.feature_groceryList.presentation

import GroceryListTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hk.grocerylist.feature_groceryList.presentation.groceryListPage.components.groceryListPageScreen
import com.hk.grocerylist.feature_groceryList.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This setContent thing is coming from Compose
        setContent{
            GroceryListTheme{

                Surface(
                ){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.groceryListPageScreen.route){

                        composable(route = Screen.groceryListPageScreen.route){
                            groceryListPageScreen(navController = navController)
                        }
                    }
                }
            }

        }
    }
}