package com.example.springbootdemo2021.model;

import java.util.Date;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/5 21:27
 */
public class GoodsDO {

    private Long id;

    private Date gmt_Create;

    private Date gmt_Modified;

    private String goods_name;

    private String goods_code;

    private String goods_type;

    private String goods_stock;

    private String goods_status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmt_Create() {
        return gmt_Create;
    }

    public void setGmt_Create(Date gmt_Create) {
        this.gmt_Create = gmt_Create;
    }

    public Date getGmt_Modified() {
        return gmt_Modified;
    }

    public void setGmt_Modified(Date gmt_Modified) {
        this.gmt_Modified = gmt_Modified;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(String goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String goods_status) {
        this.goods_status = goods_status;
    }

    @Override
    public String toString() {
        return "GoodsDO{" +
                "id=" + id +
                ", gmt_Create=" + gmt_Create +
                ", gmt_Modified=" + gmt_Modified +
                ", goods_name='" + goods_name + '\'' +
                ", goods_code='" + goods_code + '\'' +
                ", goods_type='" + goods_type + '\'' +
                ", goods_stock='" + goods_stock + '\'' +
                ", goods_status='" + goods_status + '\'' +
                '}';
    }
}
