package zhj.viewpagerdemo.MVP_2.Common;

/**
 * 作者：shiyuzhe on 2018/4/16 17:11
 * <p>
 * 邮箱：18091664559@163.com
 */
public interface DataBinder<T extends IDelegate, D extends IModel> {

    void viewBindModel(T viewDelegate, D data);
    /**
     * 将数据与View绑定，这样当数据改变的时候，框架就知道这个数据是和哪个View绑定在一起的，就可以自动改变ui
     * 当数据改变的时候，会回调本方法。
     *
     * @param viewDelegate 视图层代理
     * @param data         数据模型对象
     */
    void moudleBindView(T viewDelegate, D data);
}
