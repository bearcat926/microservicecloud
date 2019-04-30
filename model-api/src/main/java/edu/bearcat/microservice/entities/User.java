package edu.bearcat.microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by haohao on 2019-4-7.
 * 用户Entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
/*
 * 1.有下面几个注解的功能：@ToString、@Getter、@Setter、@EqualsAndHashCode、@NoArgsConstructor
 * 2.注意的是，同时使用@Data 和 @AllArgsConstructor 后 ，默认的无参构造函数失效，如果需要它，要重新设置 @NoArgsConstructor
 */
@Accessors(chain = true)
/*
 * 通过该注解可以控制getter和setter方法的形式。
 * chain若为true，则setter方法返回当前对象。
 * prefix 若为true，则getter和setter方法会忽视属性名的指定前缀（遵守驼峰命名）。
 */
public class User implements Serializable {
    private String userId;      //用户主键
    private String wxId;        //微信号
    private String wxName;      //微信昵称
    private Integer role;       //用户角色：1.买家  2.卖家 等等
    private String createTime;  //创建时间
    private String updateTime;  //修改时间，即最后一次使用时间

    //private String dbSource;
    /*
     * db_source指该数据来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，
     * 同一个信息被存储到不同数据库
     */
}