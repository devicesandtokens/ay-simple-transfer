package com.lovisgod.simpletransfer.utils

import android.app.Dialog
import android.widget.EditText

fun EditText.getTextValue(): String {
    return this.text.toString()
}

fun Dialog.showDialog(message: String) {
    this.show()
}

fun Dialog.cancel() {
    this.dismiss()
}