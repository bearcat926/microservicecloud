package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by haohao on 2019-4-7.
 * 餐馆Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Restaurant implements Serializable {
    private String restaurantId;            //餐馆主键
    private String userId;                  //店主ID
    private String restaurantName;          //餐馆名称
    private String restaurantProvince;      //省
    private String restaurantCity;          //市
    private String restaurantDistrict;      //区
    private String restaurantAddress;       //餐馆地址
    private String restaurantPhone;         //联系电话
    private Double restaurantScore;         //平均评分
    private String restaurantDescription;   //详细信息
    private String createTime;              //创建时间
    private String updateTime;              //修改时间

}
