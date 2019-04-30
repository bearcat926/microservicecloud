package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haohao on 2019-4-7.
 * 购物车Entity
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Cart implements Serializable{
    private String cartId;         //购物车主键
    private String userId;         //用户ID
    private String restaurantId;   //餐馆ID
    private Double cartPrice;      //购物车总价
    private Integer pocketNum;     //口袋数量
    private String createTime;     //创建时间
    private String updateTime;     //修改时间

    private List<ProductVO> products;   //商品列表

}
