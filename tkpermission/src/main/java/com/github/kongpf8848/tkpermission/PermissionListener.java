package com.github.kongpf8848.tkpermission;

public interface PermissionListener {

    /**
     * 当权限被允许时回调
     * @param permission
     */
    void granted(String permission);

    /**
     * 当权限被拒绝时回调
     * @param permission
     */
    void denied(String permission);

}
