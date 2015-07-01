package org.hy.echart.demo.vo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by evilspirit on 30/06/2015.
 */
@Table("salesinfo")
public class SalesInfoVO {

    @Id
    private int id;

    @Column
    private String salesId;

    @Column
    private String employeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "SalesInfoVO{" +
                "id=" + id +
                ", salesId='" + salesId + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
