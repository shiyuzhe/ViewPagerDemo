package zhj.viewpagerdemo.MVP_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zhj.viewpagerdemo.MVP_2.Common.IDelegate;
import zhj.viewpagerdemo.R;

public class HelloVu implements IDelegate {
    View view;
    TextView helloView;

    @Override
    public void create(LayoutInflater i, ViewGroup v) {
        view = i.inflate(R.layout.activity_hello_vu, v, false);
        helloView = view.findViewById(R.id.hello);
    }

    @Override
    public View getRootView() {
        return view;
    }

    public void setHelloMessage(String msg) {
        helloView.setText(msg);
    }

}



