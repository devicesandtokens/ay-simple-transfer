package com.lovisgod.simpletransfer

import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.lovisgod.simpletransfer.databinding.ActivityMainBinding
import com.lovisgod.simpletransfer.utils.clear
import com.lovisgod.simpletransfer.utils.customdailog
import com.lovisgod.simpletransfer.utils.getTextValue
import com.lovisgod.simpletransfer.utils.stop
import com.lovisgod.simpletransfer.viewmodels.TransferViewModel
import com.lovisgod.simpletransfer.viewmodels.TransferViewModelFactory

class MainActivity : AppCompatActivity() {
    private var token: String = ""
    private val binding:ActivityMainBinding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var dialog: Dialog


    private val viewmodel : TransferViewModel by lazy {
        ViewModelProviders.of(
            this,
            TransferViewModelFactory()
        ).get(TransferViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dialog = Dialog(this)
        setTypeItems()
        getToken()
       binding.submitBtn.setOnClickListener {
           makeTransfer()
       }
    }


    private fun setTypeItems() {
        val types = listOf("Savings", "Current")
        val adapter = ArrayAdapter(this, R.layout.list_item, types)
        (binding.accountTypeContainer.editText as AutoCompleteTextView).setAdapter(adapter)
    }

    private fun getToken() {
        dialog = customdailog(this)
        viewmodel.getToken().observe(this, Observer {
            dialog.stop()
            println(it.toString())
            it?.let {
                token = it.toString()
            }
        })
    }

    private fun makeTransfer() {
        dialog = customdailog(this)
        viewmodel.makeTransfer(token = token, amount = binding.amount.getTextValue().toInt()).
                observe(this, Observer {
                    dialog.stop()
                    it?.let {
                        Snackbar.make(binding.submitBtn, it.description.toString(), Snackbar.LENGTH_LONG).show()
                        println(it.field39.toString())
                        if (it.field39 == "00") {
                            binding.amount.clear()
                            binding.pin.clear()
                        }
                    }
                })
    }
}