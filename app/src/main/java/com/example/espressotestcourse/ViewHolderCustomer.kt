package com.example.espressotestcourse

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_customer.view.*

class ViewHolderCustomer constructor(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var emailCustomer: AppCompatTextView = itemView.txtEmail
    private var nameCustomer: AppCompatTextView = itemView.txtName

    fun bind(customer: Customer){

        emailCustomer.text = customer.email
        nameCustomer.text = customer.name
    }

}