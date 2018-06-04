package zhj.viewpagerdemo.MVP_2.Common;

import android.app.Activity;
import android.os.Bundle;

/**
 * 作者：shiyuzhe on 2018/4/16 14:12
 * <p>
 * 邮箱：18091664559@163.com
 */
public abstract class BasePresenterActivity<T extends IDelegate> extends Activity {
    protected T t;

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            t = getVuClass().newInstance();
            t.create(getLayoutInflater(), null);
            setContentView(t.getRootView());
            onBindVu();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected final void onDestroy() {
        onDestroyVu();
        t = null;
        super.onDestroy();
    }

    protected abstract Class<T> getVuClass();

    protected void onBindVu() {
    }

    ;

    protected void onDestroyVu() {
    }

    ;
}
