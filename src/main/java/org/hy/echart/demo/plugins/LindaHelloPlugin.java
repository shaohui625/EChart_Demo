package org.hy.echart.demo.plugins;

import org.hy.echart.demo.plugins.impls.EricHello;
import org.hy.echart.demo.plugins.impls.LindaHello;
import org.nutz.plugin.Plugin;

/**
 * Created by evilspirit on 1/07/2015.
 */
public class LindaHelloPlugin implements Plugin, SayHello {

    private String prefix;

    private SayHello sayHello ;

    /**
     * @return 当前插件是否能正常工作
     */
    public boolean canWork() {
        try {
            sayHello = (SayHello) Class.forName("org.hy.echart.demo.plugins.impls.LindaHello").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String say() {
        return prefix+sayHello.say();
    }
}
