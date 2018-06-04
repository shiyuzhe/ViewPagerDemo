package zhj.viewpagerdemo.ui.find;

import android.view.View;

import com.example.lib_syz.mvp.presenter.FragmentPresenter;
import com.example.lib_syz.util.ToastUtil;

import zhj.viewpagerdemo.R;

/**
 * 作者：shiyuzhe on 2018/4/16 19:47
 * <p>
 * 邮箱：18091664559@163.com
 */
public class MVPFragment1 extends FragmentPresenter<SimpleDelegate> implements View.OnClickListener {
    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        //可以同时对多个控件设置同一个点击事件,后面id参数可以传多个
        viewDelegate.setOnClickListener(this, R.id.textView);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView:
                viewDelegate.setText("设置数据");
                break;
        }
    }
}
