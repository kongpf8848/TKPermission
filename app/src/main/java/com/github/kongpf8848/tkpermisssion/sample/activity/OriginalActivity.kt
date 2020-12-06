package com.github.kongpf8848.tkpermisssion.sample.activity

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.github.kongpf8848.tkpermisssion.sample.R
import kotlinx.android.synthetic.main.activity_original.*
import java.util.*

class OriginalActivity : BaseActivity() {

    val PERMISSION_REQUEST_LOCATION = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_original)
        button1.setOnClickListener {
            requestSinglePermission()
        }
    }

    fun requestSinglePermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_LOCATION
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_LOCATION) {
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    applicationContext,
                    "requestSinglePermisson:${permissions[0]} granted",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                showReasonDialog(Arrays.asList(*permissions))
            }
        }
    }
}