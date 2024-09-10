package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDos")
    suspend fun icerikYukle() : List<ToDo>


    @Insert
    suspend fun kaydet(todo:ToDo)

    @Update
    suspend fun guncelle(todo:ToDo)

    @Delete
    suspend fun sil(todo: ToDo)

    @Query("SELECT * FROM toDos WHERE todo_icerik like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<ToDo>
}