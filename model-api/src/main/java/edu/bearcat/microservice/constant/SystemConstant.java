package edu.bearcat.microservice.constant;

/**
 * Created by haohao on 2019-4-18.
 */
public class SystemConstant {
    //JWT秘钥
    public final static String JWT_SECERT = "bear-cat-926";
    //JWT签发者
    public final static String JWT_ISSUER = "bearcat";
    //JWT过期时间 - 一周
    public final static long EXPIRE_TIME = 7*24*3600*1000;
    //初始token
    public final static String FIRST_TOKEN = "bear-cat-first-token";
}
