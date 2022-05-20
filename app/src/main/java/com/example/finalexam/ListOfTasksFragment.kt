package com.example.finalexam

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random
import androidx.fragment.app.FragmentManager
import com.example.finalexam.api.ApiService
import com.example.finalexam.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListOfTasksFragment : Fragment() {
    private lateinit var listOfCountries: List<Country>
    lateinit var recyclerView: RecyclerView
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiService = MyApplication.instance.getApiService()!!

        apiService.getCountries().enqueue(object : Callback<List<Country>> {   /// Error is here!
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                Log.e("Response size: ", response.body()!!.size.toString() + "")
                listOfCountries = response.body()!!
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list_of_tasks, container, false)
        val context: Context = view.context
        recyclerView = view.findViewById(R.id.recyclerView)
        var todoTaskAdapter = TodoTaskAdapter(listOfCountries, context)
        var linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = todoTaskAdapter
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListOfTasksFragment()
        private const val LIST_OF_CATEGORIES = "listOfCategories"
        private const val LIST_OF_TODO_TASKS = "listOfTodoTasks"
    }

}