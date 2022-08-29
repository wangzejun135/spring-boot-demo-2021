package start.model;

import java.util.Date;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/5 21:29
 */
public class OrderDO {

    private Long id;

    private Date gmt_Create;

    private Date gmt_Modified;

    private Date gmt_order;

    private Date gmt_payment;

    private Date gmt_deliver;

    private Date gmt_receive;

    private String order_num;

    private String goods_id;

    private String goods_num;

    private Long address_id;

    private Long user_id;

    private String order_status;

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

    public Date getGmt_order() {
        return gmt_order;
    }

    public void setGmt_order(Date gmt_order) {
        this.gmt_order = gmt_order;
    }

    public Date getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(Date gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public Date getGmt_deliver() {
        return gmt_deliver;
    }

    public void setGmt_deliver(Date gmt_deliver) {
        this.gmt_deliver = gmt_deliver;
    }

    public Date getGmt_receive() {
        return gmt_receive;
    }

    public void setGmt_receive(Date gmt_receive) {
        this.gmt_receive = gmt_receive;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "OrderDO{" +
                "id=" + id +
                ", gmt_Create=" + gmt_Create +
                ", gmt_Modified=" + gmt_Modified +
                ", gmt_order=" + gmt_order +
                ", gmt_payment=" + gmt_payment +
                ", gmt_deliver=" + gmt_deliver +
                ", gmt_receive=" + gmt_receive +
                ", order_num='" + order_num + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goods_num='" + goods_num + '\'' +
                ", address_id=" + address_id +
                ", user_id=" + user_id +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
