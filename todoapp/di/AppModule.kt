package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.repo.ToDoRepository
import com.example.todoapp.room.ToDoDao
import com.example.todoapp.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoRepository(tds:ToDoDataSource) : ToDoRepository {
        return ToDoRepository(tds)//tds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdao: ToDoDao) : ToDoDataSource {
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context) : ToDoDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getToDoDao()
    }
}