package zhj.viewpagerdemo.MVP_2;

import zhj.viewpagerdemo.MVP_2.Common.BasePresenterActivity;

/**
 * 作者：shiyuzhe on 2018/4/16 14:19
 * <p>
 * 邮箱：18091664559@163.com
 */
public  class HelloActivity extends BasePresenterActivity<HelloVu> {
    @Override
    protected void onBindVu() {
        t.setHelloMessage("Hello World!");
    }

    @Override
    protected Class<HelloVu> getVuClass() {
        return HelloVu.class;
    }

}
