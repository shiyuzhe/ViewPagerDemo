package zhj.viewpagerdemo.MVP_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import zhj.viewpagerdemo.MVP_2.Common.IDelegate;

/**
 * 作者：shiyuzhe on 2018/4/16 14:46
 * <p>
 * 邮箱：18091664559@163.com
 */
public abstract class BasePresenterAdapter extends BaseAdapter {
    protected IDelegate vu;

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try {
                vu = (IDelegate) getVuClass().newInstance();
                vu.create(inflater, parent);
                convertView = vu.getRootView();
                convertView.setTag(vu);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            vu = (IDelegate) convertView.getTag();
        }
        if (convertView != null) {
            onBindListItemVu(position);
        }
        return convertView;
    }

    protected abstract void onBindListItemVu(int position);

    protected abstract Class<IDelegate> getVuClass();
}
