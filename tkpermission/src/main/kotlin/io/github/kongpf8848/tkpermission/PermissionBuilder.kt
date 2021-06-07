package io.github.kongpf8848.tkpermission

/**
 * 单个权限
 */
class PermissionBuilder {
    /**
     * 权限允许时回调
     */
    var granted: (permission:String) -> Unit = {}

    /**
     * 权限拒绝时回调
     */
    var denied: (permission:String) -> Unit = {}

    fun granted(callback:(permission:String) -> Unit){
        this.granted=callback
    }

    fun denied(callback:(permission:String) -> Unit){
        this.denied=callback
    }
}