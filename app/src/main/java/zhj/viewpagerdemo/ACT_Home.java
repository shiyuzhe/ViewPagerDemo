package zhj.viewpagerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import zhj.viewpagerdemo.MVP_2.HelloActivity;
import zhj.viewpagerdemo.adapterdelegate.AdapterDelegateActivity;
import zhj.viewpagerdemo.permission.ACT_TelPermession;
import zhj.viewpagerdemo.trans.ACT_TransF;
import zhj.viewpagerdemo.ui.Main2Activity;
import zhj.viewpagerdemo.ui.MainActivity;

public class ACT_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__home);
    }

    public void PageView1(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void PageView2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void TextView3(View view) {
        startActivity(new Intent(this, Main4Activity.class));
    }

    public void HelloActivity(View view) {
        startActivity(new Intent(this, HelloActivity.class));
    }

    public void AdapterDelegates(View view) {
        startActivity(new Intent(this, AdapterDelegateActivity.class));
    }

    public void TelPermission(View view) {
        startActivity(new Intent(this, ACT_TelPermession.class));
    }

    public void ACT_TransF(View view) {
        startActivity(new Intent(this, ACT_TransF.class));
    }
}
