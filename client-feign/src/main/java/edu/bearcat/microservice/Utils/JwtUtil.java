package edu.bearcat.microservice.Utils;

import edu.bearcat.microservice.constant.SystemConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by haohao on 2019-4-18.
 */
public class JwtUtil {
    /**
     * 签发JWT
     * @param ttlMillis
     * @return  String
     *
     */
    public static String createJWT(String openId, String nickName, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();

        //自定义属性
        Map<String,Object> map = new HashMap<>();
        map.put("openId",openId);
        map.put("nickName",nickName);

        //创建JwtBuilder
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")    //设置header
                .setHeaderParam("alg", "HS256")
                .setIssuer("bearcat")       // 签发者
                .setClaims(map)
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 根据签名，获取generalKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     *
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     *
     * @param token
     * @param openId
     * @param nickName
     * @return
     * @throws Exception
     */
    public static boolean validateJWT(String token,String openId,String nickName) throws Exception {
        //再生成JWT并返回数据
        Claims claims = JwtUtil.parseJWT(token);
        String cId = (String) claims.get("openId");
        String cName = (String) claims.get("nickName");
        String cIssuer = claims.getIssuer();
        Date now = new Date();
        Date expiration = claims.getExpiration();
        Date notBefore = Optional.ofNullable(claims.getNotBefore()).orElse(now);

        //检测id是否相同，用户昵称是否相同，签发者是否相同，JWT是否过期
        if(!cId.equals(openId)){
            return false;
        }
        if(!cName.equals(nickName)){
            return false;
        }
        if(cIssuer.equals(SystemConstant.JWT_ISSUER)){
            return false;
        }
        if( now.after(notBefore) && now.before(expiration)){
            return false;
        }
        return true;
    }
}
