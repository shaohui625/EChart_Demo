package org.hy.echart.demo.plugins.impls;

import org.hy.echart.demo.plugins.SayHello;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.plugin.Plugin;

/**
 * Created by evilspirit on 1/07/2015.
 */
public class LindaHello implements SayHello {
    private final Log log = Logs.get();
    public String say() {
        return "say hello~";
    }

}
