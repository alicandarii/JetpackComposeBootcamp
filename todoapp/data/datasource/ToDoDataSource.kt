package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tdao : ToDoDao) {

    suspend fun kaydet(todo_icerik:String){
        val yeniIcerik = ToDo(0,todo_icerik)
        tdao.kaydet(yeniIcerik)
    }

    suspend fun guncelle(todo_id:Int,todo_icerik: String){
        val guncellenenIcerik = ToDo(todo_id,todo_icerik)
        tdao.guncelle(guncellenenIcerik)
    }

    suspend fun sil(todo_id: Int){
        val silinenIcerik = ToDo(todo_id,"")
        tdao.sil(silinenIcerik)
    }

    suspend fun icerikYukle() : List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext tdao.icerikYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<ToDo> = withContext(Dispatchers.IO) {
        return@withContext tdao.ara(aramaKelimesi)
    }
}