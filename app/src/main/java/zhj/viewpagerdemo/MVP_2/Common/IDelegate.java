package zhj.viewpagerdemo.MVP_2.Common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：shiyuzhe on 2018/4/16 14:11
 * <p>
 * 邮箱：18091664559@163.com
 */
public interface IDelegate {

    void create(LayoutInflater i, ViewGroup v);

    View getRootView();

}
