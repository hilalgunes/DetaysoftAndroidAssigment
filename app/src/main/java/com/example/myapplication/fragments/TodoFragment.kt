package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.TODO_URL
import com.example.myapplication.adapters.TodoRecyclerAdapter
import com.example.myapplication.data.Todo
import com.example.myapplication.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoFragment : Fragment() {

    private var todoList: List<Todo>? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.todo_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        if (todoList == null) {
            getTodoList()
        } else {
            loadTodoList()
        }

    }
    private fun loadTodoList() {
        todoList?.let {
            val adapter = TodoRecyclerAdapter(it)
            recyclerView.adapter = adapter
        }
    }

    private fun getTodoList() {

        RetrofitClient.getInstance().getTodoList(TODO_URL).enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.body() != null) {
                    todoList = response.body()
                    loadTodoList()
                } else {
                    Toast.makeText(activity, "hata oldu", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Toast.makeText(activity, "hata oldu", Toast.LENGTH_LONG).show()
            }

        })
    }

}