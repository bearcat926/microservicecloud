package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Created by haohao on 2019-4-7.
 * 菜单Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Menu {
    private String restaurantId;    //餐馆id
    private String categoryId;      //类别主键
    private Integer categoryIndex;  //类别序号
    private Integer categoryCount;  //类别总数
    private String categoryName;    //类别名称
    private String createTime;      //创建时间
    private String updateTime;      //修改时间

    List<Product> products;         //商品列表
}
