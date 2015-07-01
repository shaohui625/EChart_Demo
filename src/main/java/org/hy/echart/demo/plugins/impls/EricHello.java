package org.hy.echart.demo.plugins.impls;

import org.hy.echart.demo.plugins.SayHello;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.plugin.Plugin;

/**
 * Created by evilspirit on 1/07/2015.
 */
public class EricHello implements SayHello {

    public String say() {
        return "say hello!";
    }
}
