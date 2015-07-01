package org.hy.echart.demo;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * Created by evilspirit on 30/06/2015.
 */
@Modules(scanPackage = true)
@IocBy(type = ComboIocProvider.class,
        args = {"*org.nutz.ioc.loader.json.JsonLoader",
                "conf/init.js",
                "conf/aop.js",
                "conf/plugins.js",
                "*org.nutz.ioc.loader.annotation.AnnotationIocLoader",
                "org.hy.echart.demo",
        })
@Encoding(input = "UTF-8", output = "UTF-8")
@Ok("json")
@Fail("jsp:errors.error")
public class MainModule {
}
