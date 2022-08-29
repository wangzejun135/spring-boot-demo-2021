package start.model;

import java.util.Date;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/5 21:18
 */
public class AddressDO {

    private Long id;

    private Date gmt_Create;

    private Date gmt_Modified;

    private Long user_id;

    private String address_province;

    private String address_city;

    private String address_area;

    private String address_name;

    private String address_phone;

    private String address_details;

    private String address_status;

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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getAddress_province() {
        return address_province;
    }

    public void setAddress_province(String address_province) {
        this.address_province = address_province;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getAddress_area() {
        return address_area;
    }

    public void setAddress_area(String address_area) {
        this.address_area = address_area;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getAddress_phone() {
        return address_phone;
    }

    public void setAddress_phone(String address_phone) {
        this.address_phone = address_phone;
    }

    public String getAddress_details() {
        return address_details;
    }

    public void setAddress_details(String address_details) {
        this.address_details = address_details;
    }

    public String getAddress_status() {
        return address_status;
    }

    public void setAddress_status(String address_status) {
        this.address_status = address_status;
    }

    @Override
    public String toString() {
        return "AddressDO{" +
                "id=" + id +
                ", gmt_Create=" + gmt_Create +
                ", gmt_Modified=" + gmt_Modified +
                ", user_id=" + user_id +
                ", address_province='" + address_province + '\'' +
                ", address_city='" + address_city + '\'' +
                ", address_area='" + address_area + '\'' +
                ", address_name='" + address_name + '\'' +
                ", address_phone='" + address_phone + '\'' +
                ", address_details='" + address_details + '\'' +
                ", address_status='" + address_status + '\'' +
                '}';
    }
}
