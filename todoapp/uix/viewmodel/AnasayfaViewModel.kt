package com.example.todoapp.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var tdrepo: ToDoRepository) : ViewModel() {
    val todoListe = MutableLiveData<List<ToDo>>()

    init {
        icerikYukle()
    }

    fun sil(todo_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            tdrepo.sil(todo_id)
        }
    }

     fun icerikYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            todoListe.value = tdrepo.icerikYukle()
        }
    }

    fun ara(aramaKelimesi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            todoListe.value = tdrepo.ara(aramaKelimesi)
        }
    }

}