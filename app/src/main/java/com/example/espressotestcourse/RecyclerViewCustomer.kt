package com.example.espressotestcourse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewCustomer : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: List<Customer> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderCustomer(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_customer, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolderCustomer -> {
                holder.bind(items[position])
            }
        }
    }

    fun submitList(mList : List<Customer>){
        this.items = mList
    }

}