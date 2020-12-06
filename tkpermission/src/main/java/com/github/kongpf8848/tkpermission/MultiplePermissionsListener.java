package com.github.kongpf8848.tkpermission;

import java.util.List;

public interface MultiplePermissionsListener {

    /**
     * 全部权限被允许
     */
    void allGranted();

    /**
     * 被拒绝的权限列表
     * @param list
     */
    void denied(List<String> list);
}
