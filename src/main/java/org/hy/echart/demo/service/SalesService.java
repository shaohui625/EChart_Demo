package org.hy.echart.demo.service;

import org.hy.echart.demo.dao.SalesDao;
import org.hy.echart.demo.vo.SalesVO;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.List;

/**
 * Created by evilspirit on 30/06/2015.
 */
@IocBean
public class SalesService {

    @Inject
    private SalesDao salesDao;

    @Aop("transactionInterceptor")
    public List<SalesVO> loadChartData(){
        return salesDao.queryDatas();
    }


}
