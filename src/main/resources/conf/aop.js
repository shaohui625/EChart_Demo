/**
 * Created by evilspirit on 30/06/2015.
 */
var aop = {
    log : {
        type :'org.hy.echart.demo.LoggingInterceptor'
    },
    transactionInterceptor:{
        type : "org.nutz.aop.interceptor.TransactionInterceptor"
    },
    $aop : {
        type : 'org.nutz.ioc.aop.config.impl.JsonAopConfigration',
        fields : {
            itemList : [
                ['org\\.hy\\.echart\\.demo\\..+','query.+','ioc:log']
            ]
        }
    }
}