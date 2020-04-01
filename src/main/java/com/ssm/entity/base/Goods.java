package com.ssm.entity.base;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;


@Data
public class Goods {

    private Integer id; //商品编号

    @NotNull
    private String gname; //商品名称

    @NotNull
    private Double goprice; //原价

    @NotNull
    private Double grprice; //现价
    @NotNull
    private Integer gstore; //库存
    private String gpicture;//图片
    @NotNull
    private Integer goodstype_id; //类型（pk)

    private String typename;//查询时使用
    private MultipartFile logoImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGoprice() {
        return goprice;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public Integer getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(Integer goodstype_id) {
        this.goodstype_id = goodstype_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(MultipartFile logoImage) {
        this.logoImage = logoImage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", goprice=" + goprice +
                ", grprice=" + grprice +
                ", gstore=" + gstore +
                ", gpicture='" + gpicture + '\'' +
                ", goodstype_id=" + goodstype_id +
                ", typename='" + typename + '\'' +
                ", logoImage=" + logoImage +
                '}';
    }
}
