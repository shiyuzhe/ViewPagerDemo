package zhj.viewpagerdemo.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib_syz.View.DotViewPager;
import com.example.lib_syz.glide.Image;

import java.util.ArrayList;
import java.util.List;

import zhj.viewpagerdemo.Main3Activity;
import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.common.MyApplication;

/**
 * Created by HongJay on 2016/8/11.
 */
public class TabFragment1 extends Fragment {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    //    private ArrayList<ImageView> imageList;
    private List<ImageView> viewPagerList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment1, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        initdata();//初始化数据
        mRecyclerView.setAdapter(new MyAdapter(mDatas));
        return view;
    }

    private void initdata() {
        //初始化recycleview的数据
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 45; i++) {
            mDatas.add("item" + i);
        }
        //初始化viewpager的数据
//        int[] imageResIDs = {R.drawable.c, R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.a};
        int[] imageResIDs = {1102222305, -1354989886, 715182173, 1102222305, -1354989886};
        viewPagerList = new ArrayList<>();
        for (int i = 0; i < imageResIDs.length; i++) {
            final int id = imageResIDs[i];
            ImageView image = new ImageView(getActivity());
            Image.getBigImageWithThumbnail(MyApplication.getContext(), Image.M_teacher, id + "", image);
//            image.setBackgroundResource(imageResIDs[i]);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(MyApplication.getContext(), Main3Activity.class);
                        intent.putExtra("id", id+"");
                        startActivity(intent);
                    } catch (Exception e) {
                        Log.e("syz", e.getMessage());
                    }

                }
            });
            viewPagerList.add(image);
        }
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> mDatas;
        private static final int HEAD_VIEW = 0;//头布局
        private static final int BODY_VIEW = 1;//内容布局
        private MyPagerAdapter mPagerAdapter = new MyPagerAdapter();

        //创建构造参数，用来接受数据集
        public MyAdapter(List<String> datas) {
            this.mDatas = datas;
        }

        //创建ViewHolder
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == HEAD_VIEW) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.headview_recycleview, parent, false);
                MyHeadViewHolder viewHolder = new MyHeadViewHolder(view);
                return viewHolder;
            }
            if (viewType == BODY_VIEW) {
                //加载布局文件
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_recycle, parent, false);
                MyBodyViewHolder viewHolder = new MyBodyViewHolder(view);
                return viewHolder;
            }
            return null;
        }

        //绑定ViewHolder
        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            //将数据填充到具体的view中
            if (holder instanceof MyHeadViewHolder) {
//                ((MyHeadViewHolder) holder).viewPager.setAdapter(mPagerAdapter);
                ((MyHeadViewHolder) holder).viewPager.setAdapterWithLoop(mPagerAdapter);
                ((MyHeadViewHolder) holder).viewPager.setMarginPixel(0, 0, 100, 50);
                ((MyHeadViewHolder) holder).viewPager.setGravity(((MyHeadViewHolder) holder).viewPager.BOTTOM_RIGHT);
                //调用setAutoScroll方法开始自动滚动（如果调用了此方法，要在onDestroy中调用<span style="font-family: Arial, Helvetica, sans-serif;">setAutoScroll(false, 0, null)以确保停止滚动减少资源消耗</span>）
                ((MyHeadViewHolder) holder).viewPager.setAutoScroll(true, 300, null);
            }
            if (holder instanceof MyBodyViewHolder) {
                ((MyBodyViewHolder) holder).tv.setText(mDatas.get(position - 1));
            }
        }

        @Override
        public int getItemCount() {
            return mDatas.size() + 1;
        }

        //如果是第一项，则加载头布局
        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return HEAD_VIEW;
            } else {
                return BODY_VIEW;
            }
        }
    }

    //头布局的viewholder
    class MyHeadViewHolder extends RecyclerView.ViewHolder {
        DotViewPager viewPager;

        public MyHeadViewHolder(View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.dot);
        }
    }

    class MyBodyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyBodyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.recycle_tv);

        }
    }

    //viewpager的adapter
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return viewPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewPagerList.get(position));
            return viewPagerList.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Integer.toString(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}




