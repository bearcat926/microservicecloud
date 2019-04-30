package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haohao on 2019-4-7.
 * 订单Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Order implements Serializable {
    private String orderId;         //订单主键
    private String userId;          //用户ID
    private String restaurantId;    //餐馆ID
    private Double orderPrice;      //订单总价
    private Integer pocketNum;      //口袋数量
    private String orderStatus;     //订单状态
    private Double orderScore;      //订单评分
    private String orderComment;    //订单评论
    private String createTime;      //创建时间
    private String updateTime;      //修改时间

    private List<ProductVO> products;   //订单列表

}
