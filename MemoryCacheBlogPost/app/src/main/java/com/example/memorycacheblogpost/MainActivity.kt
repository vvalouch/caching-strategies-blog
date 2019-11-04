package com.example.memorycacheblogpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myAdapter = ListItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        my_recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        my_recyclerview.postDelayed(Runnable {
            //simulation of async calls
            ListItemCache.shared.replaceItems(
                listOf(
                    ListItem(
                        "vendor",
                        System.currentTimeMillis().toInt()
                    )
                )
            )
        }, 2000)

    }
}


