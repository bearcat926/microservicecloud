package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by haohao on 2019-4-7.
 * 商品Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product implements Serializable {
    private String productId;          //商品主键
    private String productName;        //商品名称
    private Double productPrice;       //商品单价
    private Integer productSold;      //商品库存
    private String productDescription; //商品描述
    private String productIcon;        //商品图片
    private Integer productStatus;     //商品状态
    private String categoryId;         //类别id
    private String createTime;         //创建时间
    private String updateTime;         //修改时间

}
