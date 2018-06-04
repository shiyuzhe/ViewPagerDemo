package zhj.viewpagerdemo.trans;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * 作者:shiyuzhe on 2018/6/4 18:36
 * 邮箱:18091664559@163.com
 * Desc:
 */
public class CardPageTransformer implements ViewPager.PageTransformer {
    private float SHOW_NUM = 3;
    private float SCALE = 0.8f;

    CardPageTransformer(float SHOW_NUM, float SCALE) {
        this.SHOW_NUM = SHOW_NUM;
        this.SCALE = SCALE;
    }

    @Override
    public void transformPage(@NonNull View view, float position) {
        int width = view.getWidth();
        //等比缩放
        view.setScaleX(SCALE);
        view.setScaleY(SCALE);
        //等距平移
        view.setPivotX(width / 2 + (position - (SHOW_NUM - 1) / 2) * (1 - SCALE) * width);
        view.setPivotY(view.getHeight() / 2 - (position - (SHOW_NUM - 1) / 2) * (1 - SCALE) * width);
        if (position < 0.0f) {
            view.setTranslationY(0f);
            view.setClickable(true);
            view.setAlpha(1);
        } else if (position <= SHOW_NUM) {
            view.setClickable(false);
            view.setTranslationX(-width * position);
            view.setAlpha(SHOW_NUM - position);
        } else {
            view.setAlpha(0);
        }
    }
}
