
package com.hk.grocerylist.feature_groceryList.domain.use_case



data class GroceryItemUseCases(
   val getGroceryItemsUseCase: GetGroceryItemsUseCase,
   val deleteGroceryItemUseCase: DeleteGroceryItemUseCase,
   val addGroceryItemUseCase: AddGroceryItemUseCase,
)