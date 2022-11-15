package com.hk.grocerylist.di

import android.app.Application
import androidx.room.Room
import com.hk.grocerylist.feature_groceryList.data.data_source.GroceryDataBase
import com.hk.grocerylist.feature_groceryList.data.repository.GroceryItemRepositoryImpl
import com.hk.grocerylist.feature_groceryList.domain.repository.GroceryItemRepository
import com.hk.grocerylist.feature_groceryList.domain.use_case.AddGroceryItemUseCase
import com.hk.grocerylist.feature_groceryList.domain.use_case.DeleteGroceryItemUseCase
import com.hk.grocerylist.feature_groceryList.domain.use_case.GetGroceryItemsUseCase
import com.hk.grocerylist.feature_groceryList.domain.use_case.GroceryItemUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideGroceryDataBase(app: Application): GroceryDataBase {
        return Room.databaseBuilder(app,GroceryDataBase::class.java,GroceryDataBase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideGroceryItemRepository(db:GroceryDataBase):GroceryItemRepository{
       return GroceryItemRepositoryImpl(db.groceryDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository:GroceryItemRepository):GroceryItemUseCases{
       return GroceryItemUseCases(
                   getGroceryItemsUseCase = GetGroceryItemsUseCase(repository),
                   deleteGroceryItemUseCase = DeleteGroceryItemUseCase(repository),
                   addGroceryItemUseCase = AddGroceryItemUseCase(repository)
       )
    }
}