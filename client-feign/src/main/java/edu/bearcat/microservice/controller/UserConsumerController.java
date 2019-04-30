package edu.bearcat.microservice.controller;

import edu.bearcat.microservice.Utils.UserUtil;
import edu.bearcat.microservice.entities.User;
import edu.bearcat.microservice.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by haohao on 2019-4-3.
 * 用户消费者控制层
 */
@SuppressWarnings("unchecked")
@RequestMapping("/consumer/user")
@RestController
public class UserConsumerController {

    @Autowired
    private UserClientService userClientService;

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String,Object> find(User user){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("user",userClientService.findUser(user));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody User user){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("addFlag",userClientService.addUser(user));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String,Object> modify(@RequestBody User user){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("modifyFlag",userClientService.modifyUser(user));
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public Map<String,Object> userInfo(@RequestBody Map<String,Object> map) throws Exception {
        //获取参数
        String code = (String) map.get("code");
        String encryptedData = (String) map.get("encryptedData");
        String iv = (String) map.get("iv");
        //获取openId和sessionKey
        Map<String,Object> codeMap = UserUtil.getSessionKeyOrOpenid(code).getInnerMap();
        String sessionKey = (String) codeMap.get("session_key");
        //获取用户信息
        Map<String,Object> resultMap = UserUtil.getUserInfo(encryptedData, sessionKey,iv).getInnerMap();
        String openId = (String) resultMap.get("openId");
        String nickName = (String) resultMap.get("nickName");

        //查询是否注册
        User user = userClientService.findUser(new User().setWxId(openId));
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        String date = df.format(new Date());
        if(user != null && !user.getWxName().equals(nickName)){  //用户已修改昵称
            userClientService.modifyUser(user.setWxId(openId).setWxName(nickName).setUpdateTime(date));
        }else if(user == null){   //先注册
            //创建UUID
            String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            userClientService.addUser(new User(uuid,openId,nickName,1,date,date));
        }
        resultMap.put("userInfo",userClientService.findUser(new User().setWxId(openId)));
        return resultMap;
    }

}
