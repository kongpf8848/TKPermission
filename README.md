# TKPermission
**基于Activity Result API封装的权限类库，摆脱旧的繁琐的权限申请方式，让权限申请变得无比简单轻松**:smile::smile::smile:

# 使用

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