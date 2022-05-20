package com.example.finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var fragmentTransaction = supportFragmentManager.beginTransaction()
        val listOfTasksFragment = ListOfTasksFragment.newInstance()
        fragmentTransaction.replace(R.id.listFragmentContainer, listOfTasksFragment)
            .addToBackStack("listOfTasksFragment").commit()
    }
}