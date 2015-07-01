package org.hy.echart.demo.controller;

import org.hy.echart.demo.plugins.SayHello;
import org.hy.echart.demo.service.SalesService;
import org.hy.echart.demo.vo.SalesVO;
import org.nutz.castor.Castors;
import org.nutz.filepool.FilePool;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.json.Json;
import org.nutz.lang.segment.CharSegment;
import org.nutz.lang.segment.Segment;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.*;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.plugin.IocPluginManager;
import org.nutz.plugin.PluginManager;
import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by evilspirit on 30/06/2015.
 */
@IocBean
public class DemoAction {

    @Inject
    private SalesService salesService;

    @Inject
    private FilePool tmpFilePool;

    @At("/charts/bar")
    @Ok("json")
    @POST
    public Object dataForBar(@Param("..") Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Integer> sales = new ArrayList<Integer>();
        List<String> category = new ArrayList<String>();

        //load data
        List<SalesVO> data = salesService.loadChartData();

        for(SalesVO salesVO : data){
            sales.add(salesVO.getSales());
            category.add(salesVO.getCategory());
        }

        result.put("sales", sales);
        result.put("category",category);
        return result;
    }


    /**
     * filePool
     * @param id
     * @param f
     */
    @At("/file/upload")
    @AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
    public void upload(@Param("id") int id, @Param("file") File f){
        String file = f.getName();
    }
    @At("/file/download")
    @Ok("raw:application/octet-stream")
    public Object download(@Param("id") int id){
        return tmpFilePool.getFile(id,".js");
    }

    @At("/rest/?")
    @GET
    @Aop("log")
    @Ok("json")
    public Object getRest(int id){
        PluginManager<SayHello> plugins = new IocPluginManager<SayHello>(Mvcs.getIoc(), "linda", "eric");
        SayHello sayHello = (SayHello) plugins.get();
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("result", sayHello.say());
        Segment segment = new CharSegment("[${A},${B},${C}]");
        segment.set("A","Eric").set("B","Linda").set("C",result);
        return segment.toString();
    }

    @At("/rest/?")
    @POST
    @Aop("log")
    public Object updateRest(int id, @Param("..") Map<String,Object> info){
        // TODO 这里是实现代码
        return null;
    }

    @At("/rest/?")
    @PUT
    @Aop("log")
    public Object saveRest(int id, @Param("..") Map<String,Object> info){
        // TODO 这里是实现代码
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("result",id);
        return result;
    }

    @At("/rest/?")
    @DELETE
    @Aop("log")
    public Object deleteRest(int id){
        // TODO 这里是实现代码
        return null;
    }

}
