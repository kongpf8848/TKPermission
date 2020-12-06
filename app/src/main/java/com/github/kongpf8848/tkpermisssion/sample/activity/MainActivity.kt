package com.github.kongpf8848.tkpermisssion.sample.activity

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.github.kongpf8848.tkpermission.permission
import com.github.kongpf8848.tkpermission.permissions
import com.github.kongpf8848.tkpermisssion.sample.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            requestSinglePermisson()
        }
        button2.setOnClickListener {
            requestMultiplePermissions()
        }
        button3.setOnClickListener {
            startActivity(Intent(this,
                PermissionJavaActivity::class.java))
        }
        button4.setOnClickListener {
            startActivity(Intent(this,
                OriginalActivity::class.java))
        }
    }

    /**
     * 申请单个权限
     */
    fun requestSinglePermisson() {
        permission(Manifest.permission.CAMERA) {
            granted {
                Toast.makeText(applicationContext, "requestSinglePermisson:${it} granted",Toast.LENGTH_LONG).show()
            }
            denied {
                //Toast.makeText(applicationContext, "requestSinglePermisson:${it} denied",Toast.LENGTH_LONG).show()
                showReasonDialog(Arrays.asList(it))
            }
        }
    }

    /**
     * 申请多个权限
     */
    fun requestMultiplePermissions() {
        permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO) {
            allGranted{
                Toast.makeText(applicationContext, "requestMultiplePermissions,all granted",Toast.LENGTH_LONG).show()
            }
            denied {
                //Toast.makeText(applicationContext, "requestMultiplePermissions,denied:${it}",Toast.LENGTH_LONG).show()
                showReasonDialog(it)
            }
        }
    }


}