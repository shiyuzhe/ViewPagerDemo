package zhj.viewpagerdemo.serialize;

import java.io.Serializable;

/**
 * 作者：shiyuzhe on 2018/4/20 20:15
 * <p>
 * 邮箱：18091664559@163.com
 */
public class bean1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String age;

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age == null ? "" : age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
