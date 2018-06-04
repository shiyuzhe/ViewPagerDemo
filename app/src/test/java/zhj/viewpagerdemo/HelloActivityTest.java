package zhj.viewpagerdemo;

import org.junit.Before;
import org.junit.Test;

import zhj.viewpagerdemo.MVP_2.HelloActivity;
import zhj.viewpagerdemo.MVP_2.HelloVu;

/**
 * 作者：shiyuzhe on 2018/4/16 14:38
 * <p>
 * 邮箱：18091664559@163.com
 */
public class HelloActivityTest {
    HelloActivity activity;
    HelloVu vu;

    @Before
    public void setup() throws Exception {
        activity = new HelloActivity();
//        vu = Mockito.mock(HelloVu.class);
//        activity.vu = vu;
    }

    @Test
    public void testOnBindVu() {
//        activity.onBindVu();
//        verify(vu).setHelloMessage("Hello World!");
    }
}
