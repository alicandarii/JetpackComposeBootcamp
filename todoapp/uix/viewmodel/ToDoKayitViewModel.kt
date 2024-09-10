package com.example.todoapp.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoKayitViewModel @Inject constructor(var tdrepo :ToDoRepository):ViewModel(){
    fun kaydet(todo_icerik:String) {
        CoroutineScope(Dispatchers.Main).launch {
            tdrepo.kaydet(todo_icerik)
        }
    }
}