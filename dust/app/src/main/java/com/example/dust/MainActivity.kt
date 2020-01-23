package com.example.dust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list: ArrayList<APIItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addApi()

        val adapter = RecyclerAdapter(list)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        )
    }

    fun addApi()
    {
        list.add(APIItem(getString(R.string.seoul),getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(getString(R.string.incheon),getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(getString(R.string.seoul),getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))
        list.add(APIItem(getString(R.string.incheon),getString(R.string.good),getString(R.string.bad),getString(R.string.verybad)))

    }
}
