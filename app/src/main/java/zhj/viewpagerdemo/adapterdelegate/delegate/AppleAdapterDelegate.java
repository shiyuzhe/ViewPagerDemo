package zhj.viewpagerdemo.adapterdelegate.delegate;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lib_syz.rv.ItemViewDelegate;
import com.example.lib_syz.rv.ViewHolder;

import java.util.List;

import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.adapterdelegate.bean.Apple;
import zhj.viewpagerdemo.adapterdelegate.bean.DisplayableItem;

/**
 * 作者：shiyuzhe on 2018/4/18 11:14
 * <p>
 * 邮箱：18091664559@163.com
 */
public class AppleAdapterDelegate implements ItemViewDelegate<DisplayableItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.fru_apple;
    }

    @Override
    public boolean isForViewType(DisplayableItem item, int position) {
        return item instanceof Apple;
    }

    @Override
    public void convert(ViewHolder holder, DisplayableItem displayableItem, int position) {
        Log.e("syz","position:"+position);
        holder.setText(R.id.name,  ((Apple)displayableItem).getName());

    }
}
