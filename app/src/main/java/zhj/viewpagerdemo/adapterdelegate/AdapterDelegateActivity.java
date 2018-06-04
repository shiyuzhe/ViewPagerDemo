package zhj.viewpagerdemo.adapterdelegate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lib_syz.common.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import zhj.viewpagerdemo.R;
import zhj.viewpagerdemo.adapterdelegate.bean.Apple;
import zhj.viewpagerdemo.adapterdelegate.bean.DisplayableItem;
import zhj.viewpagerdemo.adapterdelegate.bean.Oriage;

public class AdapterDelegateActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_adapter_delegate;
    }

    @Override
    protected void initEvents() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        FruitAdapterDelegate adapter = new FruitAdapterDelegate(this,getData());
        rv.setAdapter(adapter);
//        adapter.update(getData(),true);
    }

    @Override
    protected void onClickNoFast(View v) {

    }


    private List<DisplayableItem> getData() {
        List<DisplayableItem> animals = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            animals.add(new Apple("Apl-" + i));
            animals.add(new Oriage("ori-" + i));
        }
        Collections.shuffle(animals);
        return animals;
    }
}
