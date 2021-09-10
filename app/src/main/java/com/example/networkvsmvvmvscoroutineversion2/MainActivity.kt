package com.example.networkvsmvvmvscoroutineversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initData()
        viewModel.retroModel.observe(this, Observer {
            var listItem : List<ItemModel> = it.items
            customAdapter.setNewData(listItem)
        })

        bt_search.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                viewModel.getData(edt_search.text.toString().trim())
            }

        })

    }

    private fun initData() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initViews() {
        customAdapter = CustomAdapter()
        customAdapter.setContext(this)

        recycler_view.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        recycler_view.adapter = customAdapter

    }
}