package com.github.kongpf8848.tkpermission

import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Activity/Fragment权限扩展函数
 */
private inline fun ComponentActivity.requestPermission(
    permission: String,
    crossinline granted: (permission:String) -> Unit = {},
    crossinline denied: (permission:String) -> Unit = {}
) {
    registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        when {
            result -> granted.invoke(permission)
            else -> denied.invoke(permission)
        }
    }.launch(permission)
}

private inline fun ComponentActivity.requestMultiplePermissions(
    vararg permissions: String,
    crossinline allGranted: () -> Unit = {},
    crossinline denied: (List<String>) -> Unit = {}
) {
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result: MutableMap<String, Boolean> ->
        val deniedList = result.filter { !it.value }.map { it.key }
        when {
            deniedList.isNotEmpty() -> {
                denied.invoke(deniedList)
            }
            else -> {
                allGranted.invoke()
            }
        }
    }.launch(permissions)
}

/**
 * 申请单个权限
 */
fun AppCompatActivity.permission(
    permission: String,
    extension: PermissionBuilder.() -> Unit
) {
    val builder = PermissionBuilder()
    builder.apply(extension)
    requestPermission(
        permission=permission,
        granted = builder.granted,
        denied = builder.denied
    )
}

/**
 * 申请多个权限
 */
fun AppCompatActivity.permissions(
    vararg permissions: String,
    extension: MultiplePermissionsBuilder.() -> Unit
) {
    val builder = MultiplePermissionsBuilder()
    builder.apply(extension)
    requestMultiplePermissions(
        permissions=*permissions,
        allGranted = builder.allGranted,
        denied = builder.denied
    )
}

private inline fun Fragment.requestPermission(
    permission: String,
    crossinline granted: (permission:String) -> Unit = {},
    crossinline denied: (permission:String) -> Unit = {}

) {
    registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
        when {
            result -> {
                granted.invoke(permission)
            }
            else -> {
                denied.invoke(permission)
            }
        }
    }.launch(permission)
}

private inline fun Fragment.requestMultiplePermissions(
    vararg permissions: String,
    crossinline allGranted: () -> Unit = {},
    crossinline denied: (List<String>) -> Unit = {}
) {
    registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result: MutableMap<String, Boolean> ->
        val deniedList = result.filter { !it.value }.map { it.key }
        when {
            deniedList.isNotEmpty() -> {
                denied.invoke(deniedList)
            }
            else -> {
                allGranted.invoke()
            }
        }
    }.launch(permissions)
}


/**
 * 申请单个权限
 */
fun Fragment.permission(
    permission: String,
    extension: PermissionBuilder.() -> Unit
) {
    val builder = PermissionBuilder()
    builder.apply(extension)
    requestPermission(
        permission=permission,
        granted = builder.granted,
        denied = builder.denied
    )
}


/**
 * 申请多个权限
 */
fun Fragment.permissions(
    vararg permissions: String,
    extension: MultiplePermissionsBuilder.() -> Unit
) {
    val builder = MultiplePermissionsBuilder()
    builder.apply(extension)
    requestMultiplePermissions(
        permissions=*permissions,
        allGranted = builder.allGranted,
        denied = builder.denied
    )
}