package org.hy.echart.demo.dao;

import org.hy.echart.demo.vo.SalesVO;
import org.nutz.dao.Dao;
import org.nutz.http.Http;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.List;

/**
 * Created by evilspirit on 30/06/2015.
 */
@IocBean
public class SalesDao {

    @Inject
    private Dao dao;

    public List<SalesVO> queryDatas(){
        List<SalesVO> result = dao.query(SalesVO.class, null);
        return result;
    }


}
