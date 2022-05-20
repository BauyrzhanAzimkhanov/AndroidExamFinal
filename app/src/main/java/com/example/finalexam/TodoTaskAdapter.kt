package com.example.finalexam

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.R

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.finalexam.model.Country

class TodoTaskAdapter(val listOfCountries: List<Country>, val context: Context) :
    RecyclerView.Adapter<TodoTaskAdapter.TodoTaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoTaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_task_recyclerview_item, parent, false)
        return TodoTaskViewHolder(view, listOfCountries)
    }

    override fun onBindViewHolder(holder: TodoTaskViewHolder, position: Int) {
        val country = listOfCountries.get(position)
        holder.statusCheckBox.isChecked = true
        holder.titleTextView.text = country.country
        holder.categoryTextView.text = country.iso2
        holder.titleTextView.setOnClickListener(View.OnClickListener { v ->
            val activity = v.context as AppCompatActivity
            val todoTaskDetailsFragment: Fragment = TodoTaskDetailsFragment()
            val bundle: Bundle = Bundle()
            bundle.putString(COUNTRY, listOfCountries.get(position).country)
            todoTaskDetailsFragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.listFragmentContainer, todoTaskDetailsFragment).addToBackStack("todoTaskDetailsFragment").commit()
        })
    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }

    class TodoTaskViewHolder(view: View, listOfCountries: List<Country>): RecyclerView.ViewHolder(view) {
        var statusCheckBox: CheckBox = view.findViewById(R.id.statusCheckBox)
        var titleTextView: TextView = view.findViewById(R.id.titleTextView)
        var categoryTextView: TextView = view.findViewById(R.id.categoryTextView)
    }

    companion object {
        const val COUNTRY = "country"
    }

}