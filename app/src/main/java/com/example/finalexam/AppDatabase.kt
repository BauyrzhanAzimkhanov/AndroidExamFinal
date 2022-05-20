package com.example.finalexam

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [TodoTask::class, Category::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun todoTaskDao(): TodoTaskDao
    abstract fun categoryDao(): CategoryDao
}