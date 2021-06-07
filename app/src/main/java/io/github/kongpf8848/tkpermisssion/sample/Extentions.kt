package io.github.kongpf8848.tkpermisssion.sample

import androidx.appcompat.app.AppCompatActivity
import io.github.kongpf8848.tkpermisssion.sample.dialog.CustomDialog

inline fun AppCompatActivity.showDialog(settings: CustomDialog.() -> Unit) : CustomDialog {
    val dialog = CustomDialog.newInstance(this)
    dialog.apply(settings).show()
    return dialog
}

