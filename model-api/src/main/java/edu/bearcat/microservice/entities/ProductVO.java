package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by haohao on 2019-4-7.
 * 商品VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductVO implements Serializable {
    private String id;              //业务id - 购物车id 或 订单id
    private String productId;	    //商品主键
    private String productName;	    //商品名称
    private Double productPrice;    //商品单价
    private String productIcon;     //商品图片
    private Integer productNum;     //商品数量
    private Integer pocketId;       //所在口袋
}
