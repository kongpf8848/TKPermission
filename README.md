# TKPermission
**基于AndroidX Activity Result API封装的权限类库，摆脱旧的繁琐的权限申请方式，让权限申请变得无比简单轻松**:smile::smile::smile:

# 功能特点
+ 使用简单，调用方式友好，兼容kotlin和java，使用kotlin语言调用更酸爽
+ 基于Google的Activity Result API封装，代码量极少，极简主义
+ 支持一次申请单个权限和多个权限，基本满足各类权限申请使用场景

# 使用

## 添加依赖

```
implementation 'com.github.kongpf8848:tkpermission:1.0.0'
```

## Kotlin

 ### 一次申请单个权限

   ```java
      permission(Manifest.permission.CAMERA) {
            /**
             * 权限允许时回调
             */
            granted {
            }
            /**
             * 权限拒绝时回调
             */
            denied {
            }
        }
   ```

 ### 一次申请多个权限

   ```java
      permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO) {
         /**
          * 多个权限全部被允许时回调
          */
         allGranted {

         }
         /**
          * 被拒绝的权限列表
          */
         denied {

         }
     }
  
   ```
## Java
 ### 一次申请单个权限

  ```java
 PermissionUtils.INSTANCE.requestPermission(this, Manifest.permission.READ_PHONE_STATE, new PermissionListener() {
             /**
              * 权限允许时回调
              */
             @Override
             public void granted(String permission) {
             }
             /**
              * 权限拒绝时回调
              */
             @Override
             public void denied(String permission) {
             }
         });
  ```

 ### 一次申请多个权限

 ```java
PermissionUtils.INSTANCE.requestMultiplePermissions(this, Arrays.asList(Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS), new MultiplePermissionsListener() {
           /**
            * 多个权限全部被允许时回调
            */
            @Override
            public void allGranted() {

            }
            /**
             * 被拒绝的权限列表
             */
            @Override
            public void denied(List<String> list) {

            }
        });
 ```
 ## 其他
 
 + 通常申请权限时，如用户拒绝后，App会弹出一个对话框，引导用户去应用信息页面去手动开启权限，其对应的代码为：
 ```java
     /**
     * 跳转到应用程序信息
     */
    fun gotoAppDetail(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:" + context.packageName)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
  
 ```
 + <font color='red'>目前Result API版本不稳定，静等Google推出稳定版本，目前activity-ktx 1.2.0-alpha06版本，fragment-ktx 1.3.0-alpha06版本可用</font>
