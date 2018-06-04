
package zhj.viewpagerdemo.ui.find;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.lib_syz.mvp.view.AppDelegate;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import java.util.ArrayList;
import java.util.List;

import zhj.viewpagerdemo.R;


/**
 * View视图层，完全移除与Presenter业务逻辑的耦合
 */
public class SimpleDelegate2 extends AppDelegate {

    public RecyclerView lrv;
    private List<String> list;
    private Adapter2 adapter2;

    @Override
    public int getRootLayoutId() {
        return R.layout.tab_fragment5;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        list = new ArrayList<>();
        lrv = get(R.id.lrv);
        adapter2 = new Adapter2(getActivity(), list);

        lrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        lrv.setAdapter(adapter2);
    }

    public void setList(List<String> list) {
        adapter2.initlist(list);
//        this.list = list;
//        adapter2.notifyDataSetChanged();
    }
}