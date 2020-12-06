package com.github.kongpf8848.tkpermisssion.sample.activity

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.github.kongpf8848.tkpermission.PermissionUtils
import com.github.kongpf8848.tkpermisssion.sample.R
import com.github.kongpf8848.tkpermisssion.sample.showDialog

open class BaseActivity:AppCompatActivity(){

    val TAG=javaClass.simpleName

    var baseActivity: BaseActivity?=null

    /**
     * 显示对话框
     */
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        baseActivity=this
    }

    fun showReasonDialog(permissions: List<String>){

        var msg =getString(
            R.string.permission_dialog_message,
            PermissionUtils.transform(
                applicationContext,
                permissions
            )
        )
        showDialog {
            title=getString(R.string.permission_dialog_title)
            message=msg
            leftClicks(getString(R.string.cancel)) {

            }
            rightClicks(getString(R.string.confirm)) {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:" + applicationContext.getPackageName())
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                applicationContext.startActivity(intent)
            }
        }

    }


}