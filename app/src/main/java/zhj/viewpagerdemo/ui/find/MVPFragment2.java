package zhj.viewpagerdemo.ui.find;

import android.view.View;

import com.example.lib_syz.mvp.presenter.FragmentPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import zhj.viewpagerdemo.R;

/**
 * 作者：shiyuzhe on 2018/4/16 19:47
 * <p>
 * 邮箱：18091664559@163.com
 */
public class MVPFragment2 extends FragmentPresenter<SimpleDelegate2> implements View.OnClickListener {

    List<String> list = Arrays.asList("1102222305", "-1354989886", "715182173", "1102222305", "-1354989886");


    @Override
    protected Class<SimpleDelegate2> getDelegateClass() {
        return SimpleDelegate2.class;
    }

    @Override
    protected void bindEvenListener() {
        super.bindEvenListener();
        //可以同时对多个控件设置同一个点击事件,后面id参数可以传多个
//        viewDelegate.setOnClickListener(this, R.id.textView);
        viewDelegate.initWidget();
        viewDelegate.setList(list);

    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.textView:
//                break;
//        }
    }
}
