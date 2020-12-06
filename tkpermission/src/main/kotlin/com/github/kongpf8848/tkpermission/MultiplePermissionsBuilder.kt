package com.github.kongpf8848.tkpermission

/**
 * 多个权限
 */
class MultiplePermissionsBuilder {

    /**
     * 多个权限全部被允许时回调
     */
    var allGranted: () -> Unit = {}

    /**
     *
     */
    var denied: (List<String>) -> Unit = {}

    /**
     *
     */
    fun allGranted(callback:()->Unit){
        this.allGranted=callback
    }

    fun denied(callback: (List<String>) -> Unit){
        this.denied=callback
    }
}