package zhj.viewpagerdemo.MVP_2.Common;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：shiyuzhe on 2018/4/16 14:15
 * <p>
 * 邮箱：18091664559@163.com
 */
public abstract class BasePresenterFragment<V extends IDelegate> extends Fragment {
    protected V vu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try {
            vu = getVuClass().newInstance();
            vu.create(inflater, container);
            onBindVu();
            view = vu.getRootView();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public final void onDestroyView() {
        onDestroyVu();
        vu = null;
        super.onDestroyView();
    }

    protected void onDestroyVu() {
    }

    ;

    protected void onBindVu() {
    }

    ;

    protected abstract Class<V> getVuClass();
}
