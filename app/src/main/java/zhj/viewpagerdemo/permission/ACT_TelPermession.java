package zhj.viewpagerdemo.permission;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lib_syz.util.ToastUtil;
import com.ninetripods.aopermission.permissionlib.annotation.NeedPermission;
import com.ninetripods.aopermission.permissionlib.annotation.PermissionCanceled;
import com.ninetripods.aopermission.permissionlib.annotation.PermissionDenied;
import com.ninetripods.aopermission.permissionlib.bean.CancelBean;
import com.ninetripods.aopermission.permissionlib.bean.DenyBean;
import com.ninetripods.aopermission.permissionlib.util.SettingUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import zhj.viewpagerdemo.R;

public class ACT_TelPermession extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__tel_permession);
    }

    @NeedPermission(value = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_NETWORK_STATE}, requestCode = 0)
    public void act_single(View view) {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
//        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Geocoder gc = new Geocoder(ACT_TelPermession.this, Locale.getDefault());
                List<Address> locationList = null;
                try {
                    locationList = gc.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (locationList != null) {
                    Address address = locationList.get(0);// 得到Address实例
                    String countryName = address.getCountryName();// 得到国家名称，比如：中国
                    ToastUtil.showToast("countryName = " + countryName, false);
                    String locality = address.getLocality();// 得到城市名称，比如：北京市
                    ToastUtil.showToast("locality = " + locality, false);
                    // for (int i = 0; address.getAddressLine(i) != null; i++) {
                    // String addressLine =
                    // address.getAddressLine(i);//得到周边信息，包括街道等，i=0，得到街道名称
                    // LogUtil.i("syz", "addressLine = " + addressLine);
                    // }
//                    UpdateLocationForReaderRequest request = new UpdateLocationForReaderRequest((int) readerid, locality, BusinessResponseUtil.buildForAndroid(new IBusinessResponseListener<ItemReader>() {
//                        @Override
//                        public void updateSuccess(List<ItemReader> newList) {
//                        }
//
//                        @Override
//                        public void updateError(String errorMessage) {
//                            // UiUtil.showLongToast(act,
//                            // errorMessage);
//                        }
//                    }));
//                    request.post();
                }
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }
        };
        // 一小時请求一次 Build.VERSION_CODES.M
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3600000, 0, locationListener);
            }
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3600000, 0, locationListener);

//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3600000, 0, locationListener);
    }

    @NeedPermission(value = {Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA}, requestCode = 10)
    public void act_double(View view) {
        ToastUtil.showToast("电话、相机权限申请通过", false);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    /**
     * 权限被拒绝
     *
     * @param bean DenyBean
     */
    @PermissionDenied
    public void dealPermission(DenyBean bean) {
        if (bean == null) return;
        ToastUtil.showToast("requestCode:" + bean.getRequestCode()
                + ",Permissions: " + Arrays.toString(bean.getDenyList().toArray()), false);
        List<String> denyList = bean.getDenyList();
        switch (bean.getRequestCode()) {
            case 10:
                //多个权限申请返回结果
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < denyList.size(); i++) {
                    if (Manifest.permission.CALL_PHONE.equals(denyList.get(i))) {
                        builder.append("电话");
                    } else if (Manifest.permission.CAMERA.equals(denyList.get(i))) {
                        builder.append("相机");
                    }
                }
                builder.append("权限被禁止，需要手动打开");
                new AlertDialog.Builder(ACT_TelPermession.this)
                        .setTitle("提示")
                        .setMessage(builder)
                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                SettingUtil.go2Setting(ACT_TelPermession.this);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();

                break;
            case 0:
                //单个权限申请返回结果
                new AlertDialog.Builder(ACT_TelPermession.this)
                        .setTitle("提示")
                        .setMessage("定位权限被禁止，需要手动打开")
                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                SettingUtil.go2Setting(ACT_TelPermession.this);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();
                break;
            default:
                break;
        }
    }

    /**
     * 权限被取消
     *
     * @param bean CancelBean
     */
    @PermissionCanceled
    public void dealCancelPermission(CancelBean bean) {
        ToastUtil.showToast("requestCode:" + bean.getRequestCode(), false);
    }

    /**
     * 在Service中申请权限
     *
     * @param view
     */
    public void startPermissionService(View view) {
        Intent intent = new Intent(this, PermissionService.class);
        startService(intent);
    }
}
