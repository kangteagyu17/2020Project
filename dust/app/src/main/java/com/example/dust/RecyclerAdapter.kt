package com.example.dust

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter (private val items:ArrayList<APIItem>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    //보여줄 아이템 개수가 몇개인지 알려줌
    override fun getItemCount() = items.size
    //생성된 View에 보여줄 데이터를 설정 해줌
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val item = items[position]


        val listener = View.OnClickListener {it ->
            Toast.makeText(it.context, "Clicked: ${item.place}", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, item)
           itemView.tag = item
        }


    }
    //보여줄 아이템 개수 만큼 View생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        //View 생성을 layout "list_item"으로 설정
        return RecyclerAdapter.ViewHolder(inflatedView)
    }
    //ViewHolder단위 객체로View의 데이터를 설정
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View = v
//
        fun bind(listener: View.OnClickListener,item: APIItem) {

            var txt_place = item.place
            view.txt_place.text = item.place
            view.txt_nowweather.text = item.nowweather
            view.txt_smalldust.text = item.smalldust
            view.txt_supersmalldust.text =item.supersmalldust
            view.setOnClickListener(listener)
            Log.e("place","1")
            Log.e("place",item.place)
        }
    }

}