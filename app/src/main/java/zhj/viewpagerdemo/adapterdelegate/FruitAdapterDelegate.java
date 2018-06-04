package zhj.viewpagerdemo.adapterdelegate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.example.lib_syz.rv.ItemViewDelegate;
import com.example.lib_syz.rv.MultiItemTypeAdapter;
import com.example.lib_syz.rv.ViewHolder;

import java.util.List;

import zhj.viewpagerdemo.adapterdelegate.bean.Apple;
import zhj.viewpagerdemo.adapterdelegate.bean.DisplayableItem;
import zhj.viewpagerdemo.adapterdelegate.delegate.AppleAdapterDelegate;
import zhj.viewpagerdemo.adapterdelegate.delegate.OriageAdapterDelegate;

/**
 * 作者：shiyuzhe on 2018/4/18 10:26
 * <p>
 * 邮箱：18091664559@163.com
 */
public class FruitAdapterDelegate extends MultiItemTypeAdapter<DisplayableItem> {
    public FruitAdapterDelegate(Context context, List<DisplayableItem> datas) {
        super(context, datas);
        addItemViewDelegate(new AppleAdapterDelegate());
        addItemViewDelegate(new OriageAdapterDelegate());
    }


//    public FruitAdapterDelegate(Context mContext) {
//        super(mContext);
//        addItemViewDelegate(new AppleAdapterDelegate());
//        addItemViewDelegate(new OriageAdapterDelegate());
//    }

}
