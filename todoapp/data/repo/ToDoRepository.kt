package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.entity.ToDo

class ToDoRepository(var tds:ToDoDataSource) {
    suspend fun kaydet(todo_icerik:String) = tds.kaydet(todo_icerik)
    suspend fun guncelle(todo_id:Int,todo_icerik: String) = tds.guncelle(todo_id,todo_icerik)
    suspend fun sil(todo_id: Int) = tds.sil(todo_id)
    suspend fun icerikYukle() : List<ToDo> = tds.icerikYukle()
    suspend fun ara(aramaKelimesi:String) = tds.ara(aramaKelimesi)
}