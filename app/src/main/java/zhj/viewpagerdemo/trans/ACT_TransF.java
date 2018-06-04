package zhj.viewpagerdemo.trans;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lib_syz.common.BaseActivity;

import butterknife.OnClick;
import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.ui.MainActivity;

public class ACT_TransF extends BaseActivity {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    //    int[] imgRes = {R.drawable.im1, R.drawable.im2, R.drawable.im3, R.drawable.im4, R.drawable.im5};
    int[] imgRes = {R.drawable.card1, R.drawable.card2, R.drawable.card3};

    @Override
    protected int getLayoutId() {
        return R.layout.act_trans_f;
    }

    @Override
    protected void initEvents() {
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //设置Page间间距
//        mViewPager.setPageMargin(40);
        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(imgRes.length > 4 ? 4 : imgRes.length);
//        mAdapter = new PagerAdapter() {
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                ImageView view = new ImageView(ACT_TransF.this);
//                view.setImageResource(imgRes[position]);
//                view.setScaleType(ImageView.ScaleType.FIT_XY);
//                view.setTag(position);
//                container.addView(view);
//                return view;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView((View) object);
//            }
//
//            @Override
//            public int getCount() {
//                return imgRes.length;
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object o) {
//                return view == o;
//            }
//        };
        mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(ACT_TransF.this);
//                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                view.setLayoutParams(lp);
//                view.setText(position + ":" + view);
                view.setScaleType(ImageView.ScaleType.FIT_XY);
//                view.setBackgroundColor(Color.parseColor("#44ff0000"));
                final int realPosition = getRealPosition(position);
                view.setImageResource(imgRes[realPosition]);
                container.addView(view);
//                view.setAdjustViewBounds(true);

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ACT_TransF.this, "click position= " + realPosition, Toast.LENGTH_SHORT).show();
                    }
                });
                return view;
            }


            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object o) {
                return view == o;
            }

            @Override
            public void startUpdate(ViewGroup container) {
                super.startUpdate(container);
                ViewPager viewPager = (ViewPager) container;
                int position = viewPager.getCurrentItem();
                if (position == 0) {
                    position = getFirstItemPosition();
                } else if (position == getCount() - 1) {
                    position = getLastItemPosition();
                }
                viewPager.setCurrentItem(position, false);

            }

            private int getRealCount() {
                return imgRes.length;
            }

            private int getRealPosition(int position) {
                return position % getRealCount();
            }

            private int getFirstItemPosition() {
                return Integer.MAX_VALUE / getRealCount() / 2 * getRealCount();
            }

            private int getLastItemPosition() {
                return Integer.MAX_VALUE / getRealCount() / 2 * getRealCount() - 1;
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(true, new CardPageTransformer(imgRes.length > 4 ? 4 : imgRes.length,0.7f));
    }

    @OnClick({R.id.alphe, R.id.rotate_down, R.id.rotate_up, R.id.rotate_y, R.id.scale_in,
            R.id.standard, R.id.cricle, R.id.stack})
    @Override
    protected void onClickNoFast(View v) {
        mViewPager.setAdapter(mAdapter);
        switch (v.getId()) {
            case R.id.alphe:
                mViewPager.setPageTransformer(true, new AlphaPageTransformer2());
                break;
            case R.id.rotate_down:
                mViewPager.setPageTransformer(false, new RotateDownPageTransformer());
                break;
            case R.id.rotate_up:
                mViewPager.setPageTransformer(false, new RotateUpPageTransformer());
                break;
            case R.id.rotate_y:
                mViewPager.setPageTransformer(false, new RotateYTransformer());
                break;
            case R.id.scale_in:
                mViewPager.setPageTransformer(false, new ScaleInTransformer());
                break;
            case R.id.stack:
                mViewPager.setPageTransformer(false, new StackPageTransformer2(imgRes.length,
                        0.8f, 0.6f, 0.4f, StackPageTransformer2.Gravity.CENTER));
                mViewPager.setCurrentItem(imgRes.length / 2);
                break;
            case R.id.standard:
                startActivity(new Intent(this, ACT_StandardViewPager.class));
                break;
            case R.id.cricle:
                startActivity(new Intent(this, ACT_CircleViewPager.class));
                break;
        }

    }
}
