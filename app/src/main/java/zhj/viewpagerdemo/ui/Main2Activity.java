package zhj.viewpagerdemo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.adapter.MyFragmentPagerAdapter;
import zhj.viewpagerdemo.ui.find.Fragment2;
import zhj.viewpagerdemo.ui.find.Fragment3;
import zhj.viewpagerdemo.ui.find.Fragment4;
import zhj.viewpagerdemo.ui.find.Fragment5;
import zhj.viewpagerdemo.ui.find.Fragment1;

public class Main2Activity extends AppCompatActivity {

    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private RadioGroup rgGroup;
    private List<Fragment> fragments;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏掉系统原先的导航栏
        setContentView(R.layout.activity_main2);
        mViewPager = (ViewPager) findViewById(R.id.vp_main);

        fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(myFragmentPagerAdapter);


        rgGroup = (RadioGroup) findViewById(R.id.rg_group);
        rgGroup.check(R.id.rb_home);
        //当点击底部按钮时切换页面
        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_home) {
                    mViewPager.setCurrentItem(0, false);//去掉切换页面的动画
                } else if (i == R.id.rb_news) {
                    mViewPager.setCurrentItem(1, false);
                } else if (i == R.id.rb_service) {
                    mViewPager.setCurrentItem(2, false);
                } else if (i == R.id.rb_gov) {
                    mViewPager.setCurrentItem(3, false);
                } else if (i == R.id.rb_setting) {
                    mViewPager.setCurrentItem(4, false);
                }

            }
        });
        //防止频繁的销毁视图
        //ViewPager默认缓存左右相邻界面，为了避免不必要的重新数据加载（重复调用onCreateView()），
        // 因为有5个tab，因此将离线缓存的半径设置为4，即setOffscreenPageLimit(4)。
        mViewPager.setOffscreenPageLimit(4);
    }

}
