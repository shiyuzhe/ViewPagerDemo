package zhj.viewpagerdemo.adapterdelegate.bean;

/**
 * 作者：shiyuzhe on 2018/4/18 10:27
 * <p>
 * 邮箱：18091664559@163.com
 */
public class Fruit implements DisplayableItem {

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? "" : name;
    }
}
