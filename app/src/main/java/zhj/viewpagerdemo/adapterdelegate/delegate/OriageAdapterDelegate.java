package zhj.viewpagerdemo.adapterdelegate.delegate;

import com.example.lib_syz.rv.ItemViewDelegate;
import com.example.lib_syz.rv.ViewHolder;

import java.util.List;

import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.adapterdelegate.bean.Apple;
import zhj.viewpagerdemo.adapterdelegate.bean.DisplayableItem;
import zhj.viewpagerdemo.adapterdelegate.bean.Oriage;

/**
 * 作者：shiyuzhe on 2018/4/18 11:14
 * <p>
 * 邮箱：18091664559@163.com
 */
public class OriageAdapterDelegate implements ItemViewDelegate<DisplayableItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.fru_oriage;
    }

    @Override
    public boolean isForViewType(DisplayableItem item, int position) {
        return item instanceof Oriage;
    }

    @Override
    public void convert(ViewHolder holder, DisplayableItem displayableItem, int position) {

        holder.setText(R.id.name, ((Oriage) displayableItem).getName());
    }

//    @Override
//    public boolean isForViewType(List<DisplayableItem> item, int position) {
//        return item.get(position) instanceof Oriage;
//    }
//
//    @Override
//    public void convert(ViewHolder holder, List<DisplayableItem> displayableItems, int position) {
////        AppleViewHolder vh = (AppleViewHolder) holder;
//        Oriage oriage = (Oriage) displayableItems.get(position);
//        holder.setText(R.id.name, oriage.getName());
//
////        vh.name.setText(apple.getName());
//
//    }
//    static class AppleViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView name;
//
//        public AppleViewHolder(View itemView) {
//            super(itemView);
//            name =itemView.findViewById(R.id.name);
//        }
//    }
}
