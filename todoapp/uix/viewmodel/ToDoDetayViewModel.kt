package com.example.todoapp.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoDetayViewModel @Inject constructor(var tdrepo:ToDoRepository) : ViewModel() {

    fun guncelle(todo_id:Int,todo_icerik: String) {
        CoroutineScope(Dispatchers.Main).launch {
            tdrepo.guncelle(todo_id,todo_icerik)
        }
    }
}