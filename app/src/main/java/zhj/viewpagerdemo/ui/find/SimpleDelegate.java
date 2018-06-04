
package zhj.viewpagerdemo.ui.find;

import android.widget.TextView;

import com.example.lib_syz.mvp.view.AppDelegate;

import zhj.viewpagerdemo.R;


/**
 * View视图层，完全移除与Presenter业务逻辑的耦合
 *
 * @author kymjs (http://www.kymjs.com/) on 10/23/15.
 */
public class SimpleDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.tab_fragment2;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView textView = get(R.id.titile);
        textView.setText("在视图代理层创建布局");
    }

    public void setText(String text) {
        //get(id)等同于bindview(id)
        TextView textView = get(R.id.titile);
        textView.setText(text);
    }
}