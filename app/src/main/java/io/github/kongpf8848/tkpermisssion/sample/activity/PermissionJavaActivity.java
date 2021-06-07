package io.github.kongpf8848.tkpermisssion.sample.activity;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

import io.github.kongpf8848.tkpermission.MultiplePermissionsListener;
import io.github.kongpf8848.tkpermission.PermissionListener;
import io.github.kongpf8848.tkpermission.PermissionUtils;
import io.github.kongpf8848.tkpermisssion.sample.R;

public class PermissionJavaActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            requestSinglePermisson();
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(v ->
                requestMultiplePermissions()
        );

    }

    /**
     * 申请单个权限
     */
    private void requestSinglePermisson() {
        PermissionUtils.INSTANCE.requestPermission(this, Manifest.permission.READ_PHONE_STATE, new PermissionListener() {
            @Override
            public void granted(String permission) {
                Toast.makeText(getApplicationContext(), "requestSinglePermisson:"+permission+" granted",Toast.LENGTH_LONG).show();
            }

            @Override
            public void denied(String permission) {
                //Toast.makeText(getApplicationContext(), "requestSinglePermisson:"+permission+" denied",Toast.LENGTH_LONG).show();
                showReasonDialog(Arrays.asList(permission));
            }
        });
    }

    /**
     * 申请多个权限
     */
    private void requestMultiplePermissions(){
        PermissionUtils.INSTANCE.requestMultiplePermissions(this,
                Arrays.asList(Manifest.permission.READ_CONTACTS, Manifest.permission.READ_SMS), new MultiplePermissionsListener() {
                    @Override
                    public void allGranted() {
                        Toast.makeText(getApplicationContext(), "requestMultiplePermissions,all granted",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void denied(List<String> list) {
                        //Toast.makeText(getApplicationContext(), "requestMultiplePermissions,denied:"+list,Toast.LENGTH_LONG).show();
                        showReasonDialog(list);
                    }
                });
    }
}