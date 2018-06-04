package zhj.viewpagerdemo.trans;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import zhj.viewpagerdemo.R;


public class ACT_CircleViewPager extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;

    int[] imgRes = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.im1,
            R.drawable.im2, R.drawable.im3, R.drawable.im4, R.drawable.im5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_viewpager);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mViewPager.setPageMargin(40);
        mAdapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView view = new ImageView(ACT_CircleViewPager.this);
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
                        Toast.makeText(ACT_CircleViewPager.this, "click position= " + realPosition, Toast.LENGTH_SHORT).show();
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
        mViewPager.setPageTransformer(true, new AlphaPageTransformer());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String[] effects = this.getResources().getStringArray(R.array.magic_effect);
        for (String effect : effects)
            menu.add(effect);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = item.getTitle().toString();
        mViewPager.setAdapter(mAdapter);

        if ("RotateDown".equals(title)) {
            mViewPager.setPageTransformer(true, new RotateDownPageTransformer());
        } else if ("RotateUp".equals(title)) {
            mViewPager.setPageTransformer(true, new RotateUpPageTransformer());
        } else if ("RotateY".equals(title)) {
            mViewPager.setPageTransformer(true, new RotateYTransformer(45));
        } else if ("Standard".equals(title)) {
//            mViewPager.setClipChildren(false);
            mViewPager.setPageTransformer(true, NonPageTransformer.INSTANCE);
        } else if ("Alpha".equals(title)) {
//            mViewPager.setClipChildren(false);
            mViewPager.setPageTransformer(true, new AlphaPageTransformer());
        } else if ("ScaleIn".equals(title)) {
            mViewPager.setPageTransformer(true, new ScaleInTransformer());
        } else if ("RotateDown and Alpha".equals(title)) {
            mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer()));
        } else if ("RotateDown and Alpha And ScaleIn".equals(title)) {
            mViewPager.setPageTransformer(true, new RotateDownPageTransformer(new AlphaPageTransformer(new ScaleInTransformer())));
        }else if ("stack".equals(title)) {
            mViewPager.setPageTransformer(false, new StackPageTransformer(imgRes.length,
                    0.8f, 0.7f, 0.4f, StackPageTransformer.Gravity.CENTER));
        }


        setTitle(title);

        return true;
    }
}
