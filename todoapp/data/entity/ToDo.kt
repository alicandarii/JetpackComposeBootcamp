package com.example.todoapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "toDos")
data class ToDo(@PrimaryKey(autoGenerate = true)
                @ColumnInfo(name = "todo_id") @NotNull var todo_id:Int,
                @ColumnInfo(name = "todo_icerik") @NotNull var todo_icerik:String) {
}