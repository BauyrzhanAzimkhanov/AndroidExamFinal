package com.example.finalexam

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoTaskDao {
    @Query("SELECT * FROM todo_tasks")
    fun getAllTodoTasks(): List<TodoTask>

    @Query("SELECT * FROM todo_tasks WHERE todoTaskId = :todoTaskId")
    fun getTodoTaskById(todoTaskId: Long): TodoTask

    @Insert
    fun insert(todoTask: TodoTask): Long
}