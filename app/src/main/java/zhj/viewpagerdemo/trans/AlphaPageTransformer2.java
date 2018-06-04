package zhj.viewpagerdemo.trans;

import android.util.Log;
import android.view.View;

public class AlphaPageTransformer2 extends BasePageTransformer {
    private float SHOW_NUM = 3;
    private float SCALE = 0.8f;

    public AlphaPageTransformer2() {
    }

    public AlphaPageTransformer2(float SHOW_NUM, float SCALE) {
        this.SHOW_NUM = SHOW_NUM;
        this.SCALE = SCALE;
    }


    public void pageTransform(View view, float position) {

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
            Log.e("viewpager", "position:" + position);
            view.setAlpha(0);
        }
    }
}
