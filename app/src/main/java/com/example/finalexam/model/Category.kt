package com.example.finalexam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "categories")
data class Category(@PrimaryKey(autoGenerate = true) var categoryId: Long? = null,
                    @ColumnInfo(name = "title") var title: String? = null
)
