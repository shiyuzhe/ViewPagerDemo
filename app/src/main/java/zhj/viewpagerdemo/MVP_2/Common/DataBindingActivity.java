package zhj.viewpagerdemo.MVP_2.Common;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

/**
 * 作者：shiyuzhe on 2018/4/16 17:15
 * <p>
 * 邮箱：18091664559@163.com
 */
public abstract class DataBindingActivity<T extends IDelegate> extends BasePresenterActivity<T> {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    protected DataBinder binder;

    public abstract DataBinder getDataBinder();

    public <D extends IModel> void notifyModelChanged(D data) {
        binder.viewBindModel(t, data);
    }
}
