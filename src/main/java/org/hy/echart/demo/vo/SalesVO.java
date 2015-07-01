package org.hy.echart.demo.vo;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * Created by evilspirit on 30/06/2015.
 */
@Table("sales")
public class SalesVO {

    @Id
    private int id;

    @Column
    private String category;

    @Column
    private int sales;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "SalesVO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", sales=" + sales +
                '}';
    }
}
