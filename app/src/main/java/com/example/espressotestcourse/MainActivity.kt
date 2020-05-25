package com.example.espressotestcourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mRecyclerViewCustomer : RecyclerViewCustomer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }


    private fun initRecyclerView(){
        recyclerViewCustomer.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            mRecyclerViewCustomer = RecyclerViewCustomer()
            adapter  = mRecyclerViewCustomer
        }
    }

    private fun addDataSet(){
        val data = listOf<Customer>(
            Customer("Marta@gmail.com", "Marta"),
            Customer("Maria@gmail.com", "Maria"),
            Customer("João@gmail.com", "João"),
            Customer("PedroVasquez@gmail.com", "Pedro"),
            Customer("CarlosLopes@gmail.com", "Carlos"),
            Customer("JessicaAguiar@gmail.com", "Jessica"),
            Customer("HerriqueTavarez@gmail.com", "Herrique"),
            Customer("JoanaLopes@gmail.com", "Joana"),
            Customer("PedroSegundo@gmail.com", "Pedro"),
            Customer("AnaMaria@gmail.com", "Ana"),
            Customer("JoãoRoberto@gmail.com", "João")
        )
        mRecyclerViewCustomer.submitList(data)
    }

}
