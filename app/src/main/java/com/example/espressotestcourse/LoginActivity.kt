package com.example.espressotestcourse

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()
    }

    private fun setListeners() {
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnLogin -> {
                when {
                    verifyFields() -> {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                    }
                    else -> {
                        showDialog()
                    }
                }

            }
        }
    }



    private fun verifyFields(): Boolean {
        return edtEmail.text.toString() != "" && edtPassword.text.toString() != ""
    }

    private fun showDialog() {
        val mDialog = Dialog(this)
        mDialog.setContentView(R.layout.dialog)
        mDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val btn = mDialog.findViewById<AppCompatButton>(R.id.btnCloseDialog)
        btn.setOnClickListener {
            mDialog.dismiss()
        }
        mDialog.show()
    }

}
