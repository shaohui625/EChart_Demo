package org.hy.echart.demo.vo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import java.util.Arrays;
import java.util.List;

/**
 * Created by evilspirit on 1/07/2015.
 */
@Table("employee")
public class EmployeeVo {

    @Name
    private String id;

    @Column
    private String name;

    @Column
    private int age;


    @Many(target = SalesInfoVO.class, field = "employeeId")
    private List<SalesInfoVO> salesInfoVOs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SalesInfoVO> getSalesInfoVOs() {
        return salesInfoVOs;
    }

    public void setSalesInfoVOs(List<SalesInfoVO> salesInfoVOs) {
        this.salesInfoVOs = salesInfoVOs;
    }

    @Override
    public String toString() {
        return "EmployeeVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salesInfoVOs=" + Arrays.asList(salesInfoVOs) +
                '}';
    }
}
