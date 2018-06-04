package zhj.viewpagerdemo.ui.find;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lib_syz.glide.Image;

import java.util.List;

import zhj.viewpagerdemo.R;

/**
 * 作者：shiyuzhe on 2018/4/17 09:57
 * <p>
 * 邮箱：18091664559@163.com
 */
public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {
    private Context context;
    private List<String> list;

    public Adapter2(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void initlist( List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fra2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Image.getImageWithThumbnail(context, Image.M_teacher, list.get(position) + "", holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv_fra2);
        }
    }

}
