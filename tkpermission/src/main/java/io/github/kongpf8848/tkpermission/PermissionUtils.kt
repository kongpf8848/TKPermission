package io.github.kongpf8848.tkpermission

import android.content.Context
import android.content.pm.PackageManager
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.fragment.app.Fragment
import java.util.*
import java.util.jar.Manifest

object PermissionUtils {

    /**
     * 申请单个权限
     * @param activity   Activity
     * @param permission 权限名称
     * @param listener   回调
     */
    fun requestPermission(
        activity: ComponentActivity,
        permission: String,
        listener: PermissionListener
    ) {
        activity.registerForActivityResult(
            RequestPermission()
        ) { result ->
            if (result) {
                listener.granted(permission)
            } else {
                listener.denied(permission)
            }
        }.launch(permission)
    }

    fun requestPermission(
        fragment: Fragment,
        permission: String,
        listener: PermissionListener
    ) {
        fragment.registerForActivityResult(
            RequestPermission()
        ) { result ->
            if (result) {
                listener.granted(permission)
            } else {
                listener.denied(permission)
            }
        }.launch(permission)
    }

    /**
     * 申请多个权限
     * @param activity     Activity
     * @param permissions 权限名称列表
     * @param listener    回调
     */
    fun requestMultiplePermissions(
        activity: ComponentActivity,
        permissions: List<String>,
        listener: MultiplePermissionsListener
    ) {
        activity.registerForActivityResult(
            RequestMultiplePermissions()
        ) { result ->
            val deniedList = result.filter { !it.value }.map { it.key }
            when {
                deniedList.isNotEmpty() -> {
                    listener.denied(deniedList)
                }
                else -> {
                    listener.allGranted()
                }
            }
        }.launch(permissions.toTypedArray())
    }

    fun requestMultiplePermissions(
        fragment: Fragment,
        permissions:List<String>,
        listener: MultiplePermissionsListener
    ) {
        fragment.registerForActivityResult(
            RequestMultiplePermissions()
        ) { result ->
            val deniedList = result.filter { !it.value }.map { it.key }
            when {
                deniedList.isNotEmpty() -> {
                    listener.denied(deniedList)
                }
                else -> {
                    listener.allGranted()
                }
            }
        }.launch(permissions.toTypedArray())
    }


    fun transform(context: Context, vararg permissions: String): String {
        return transform(
            context,
            Arrays.asList(*permissions)
        )
    }

    /**
     * 转换权限名称,如
     *android.permission.CAMERA->相机
     */
    fun transform(context: Context, permissions: List<String>): String {
        android.Manifest.permission.CAMERA
        val textList: MutableList<String?> = ArrayList()
        val pm = context.packageManager
        for (permission in permissions) {
            var message = ""
            try {
                val permissionInfo = pm.getPermissionInfo(permission, 0)
                if(permissionInfo.group!=null && !permissionInfo.group.equals("android.permission-group.UNDEFINED")) {
                    val groupInfo = pm.getPermissionGroupInfo(permissionInfo.group!!, 0)
                    message = groupInfo.loadLabel(pm).toString()
                }
                else{
                    message=permissionInfo.loadLabel(pm).toString()
                }
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
                message=permission
            }
            if (!textList.contains(message)) {
                textList.add(message)
            }
        }
        return TextUtils.join("、", textList)
    }

}