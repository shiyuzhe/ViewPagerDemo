package zhj.viewpagerdemo;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lib_syz.common.BaseActivity;

import butterknife.BindView;

public class Main4Activity extends BaseActivity {

    @BindView(R.id.textView2)
    TextView textView2;
    private int i = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main4;
    }

    @Override
    protected void initEvents() {
        textView2.setOnClickListener(this);
    }

    @Override
    protected void onClickNoFast(View v) {
        switch (v.getId()) {
            case R.id.textView2:
                Log.e("syz", "click  textView：" + i++);
                break;
        }
    }

}
