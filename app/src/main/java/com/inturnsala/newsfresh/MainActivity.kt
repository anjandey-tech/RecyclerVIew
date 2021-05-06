package com.inturnsala.newsfresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this) // assign layout
        // link adapter to recycler view

              val items = fetchData()
        ////adapter need data, which is provided by the activity so we pass item
        val adapter = NewsListAdapter(items,this)
        recyclerView.adapter = adapter
    }
    private  fun fetchData() : ArrayList<String>
    {
       val list = ArrayList<String>()
        for(i in 0 until 100) {
            list.add("items $i")
        }

        return list
    }

    override fun onItemClicked(items: String)
    {
       Toast.makeText(this, "clicked item is $items",Toast.LENGTH_SHORT).show()
    }
}