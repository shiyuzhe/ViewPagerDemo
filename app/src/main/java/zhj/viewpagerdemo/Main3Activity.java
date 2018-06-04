package zhj.viewpagerdemo;
import android.view.View;
import android.widget.TextView;

import com.example.lib_syz.common.BaseActivity;

import butterknife.BindView;

public class Main3Activity extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main3;
    }

    @Override
    protected void initEvents() {
        String id = getIntent().getStringExtra("id");
        tv.setText("id:" + id);


    }

    @Override
    protected void onClickNoFast(View v) {

    }
}
