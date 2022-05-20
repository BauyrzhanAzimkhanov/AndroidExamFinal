package com.example.finalexam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.example.finalexam.api.ApiService
import com.example.finalexam.model.Country
import com.example.finalexam.model.CountryData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoTaskDetailsFragment : Fragment() {

    lateinit var country: CountryData
//    lateinit var dataBase: AppDatabase
//    lateinit var todoTaskDao: TodoTaskDao
//    lateinit var categoryDao: CategoryDao
    lateinit var description: TextView
    lateinit var status: CheckBox
    lateinit var duration: TextView
    lateinit var title: TextView
    lateinit var category: TextView
    lateinit var apiService: ApiService

    var countryName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null && !savedInstanceState.isEmpty) {
            countryName = savedInstanceState.getString(COUNTRY)!!
        }
        var bundle: Bundle? = this.arguments
        if(bundle != null && !bundle.isEmpty) {
            countryName = bundle.getString(COUNTRY) + 1
        }
//        dataBase = MyApplication.instance.getDataBase()!!
//        todoTaskDao = dataBase.todoTaskDao()
//        categoryDao = dataBase.categoryDao()
//        todoTask = todoTaskDao.getTodoTaskById(countryId)
//        categoryClassUnit = categoryDao.getCategoryById(todoTask.category)
        apiService = MyApplication.instance.getApiService()!!
        apiService.getCountryDataByID(COUNTRY).enqueue(object: Callback<CountryData>{
            override fun onResponse(call: Call<CountryData>, response: Response<CountryData>) {
                country = response.body()!!
            }

            override fun onFailure(call: Call<CountryData>, t: Throwable) {
                Log.e("Detailed fragment error", "onFailure")
            }
        })
        /*country = CountryData("fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd","fgd")*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_task_details, container, false)
        initUI(view)
        title.text = country.country
        description.text = "Confirmed: " + country.confirmed
        status.isChecked = true
        duration.text = "Deaths: " + country.deaths
        category.text = "Recovered: " + country.recovered
        return view
    }

    private fun initUI(view: View) {
        title = view.findViewById(R.id.titleTextViewDetailed) as TextView
        category = view.findViewById(R.id.categoryTextViewDetailed) as TextView
        duration = view.findViewById(R.id.durationTextViewDetailed) as TextView
        description = view.findViewById(R.id.descriptionTextViewDetailed) as TextView
        status = view.findViewById(R.id.statusCheckBoxDetailed) as CheckBox
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(COUNTRY, countryName)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TodoTaskDetailsFragment()
        private const val COUNTRY = "country"
    }


}