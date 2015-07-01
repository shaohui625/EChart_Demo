/**
 * Created by evilspirit on 30/06/2015.
 */
var conf = {
    dataSource: {
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            depose: 'close'
        },
        fields: {
            driverClassName: "com.mysql.jdbc.Driver",
            url: "jdbc:mysql:///mytest",
            username: "root",
            password: ""
        }
    },
    dao : {
        type : "org.nutz.dao.impl.NutDao",
        args : [{refer:"dataSource"}]
    },
    tmpFilePool : {
        type : 'org.nutz.filepool.NutFilePool',
        // max files 500
        args : [ "~/why/upload/tmps", 500 ]
    },
    uploadFileContext : {
        type : 'org.nutz.mvc.upload.UploadingContext',
        singleton : false,
        args : [ { refer : 'tmpFilePool' } ],
        fields : {
            // ignore null file, default false
            ignoreNull : true,
            // single file size 1M 单个文件最大尺寸(大约的值，单位为字节，即 1048576 为 1M)
            maxFileSize : 1048576,
            // file suffix allowed 正则表达式匹配可以支持的文件名
            nameFilter : '^(.+[.])(gif|jpg|png|js)$'
        }
    },
    myUpload : {
        type : 'org.nutz.mvc.upload.UploadAdaptor',
        singleton : false,
        args : [ { refer : 'uploadFileContext' } ]
    }
}