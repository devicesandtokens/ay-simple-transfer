package com.lovisgod.simpletransfer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lovisgod.simpletransfer.viewmodels.TransferViewModel
import com.lovisgod.simpletransfer.viewmodels.TransferViewModelFactory

class MainActivity : AppCompatActivity() {
    private var token: String = ""

    private val viewmodel : TransferViewModel by lazy {
        ViewModelProviders.of(
            this,
            TransferViewModelFactory()
        ).get(TransferViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getToken()

    }

    private fun getToken() {
        viewmodel.getToken().observe(this, Observer {
            println(it.toString())
            it?.let {
                token = it.toString()
            }
        })
    }
}