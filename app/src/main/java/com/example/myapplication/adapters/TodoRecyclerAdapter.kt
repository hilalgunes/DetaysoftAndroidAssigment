package com.example.myapplication.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Todo

//recyclerView de verilerin ekranda görüntülenmesi için adapter oluşturuldu
class TodoRecyclerAdapter(private val itemList: List<Todo>) : RecyclerView.Adapter<ItemListViewHolder>() {


    //Adapter oluşturulduğunda viewHolder başlatılır
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        return ItemListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todo_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bindItems(itemList[position])
    }
}

//Görüntüye ve metne eklemek için görünümler tutulur
class ItemListViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){

    fun bindItems(item : Todo) {
        val description = itemView.findViewById(R.id.todo_item_text) as TextView

        if (item.completed == true) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                description.setBackgroundColor(itemView.context.resources.getColor(R.color.green, null))
            } else {
                description.setBackgroundColor(itemView.context.resources.getColor(R.color.green))
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                description.setBackgroundColor(itemView.context.resources.getColor(R.color.red, null))
            } else {
                description.setBackgroundColor(itemView.context.resources.getColor(R.color.red))
            }
        }
        description.text= item.title
    }
}