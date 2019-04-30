package edu.bearcat.microservice.cfgBeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by haohao on 2019-4-3.
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced   //开启客户端的负载均衡功能，默认使用轮询策略访问Server
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    public IRule myRule(){
//        //启用随机算法，替代默认的轮询算法
//        //return new RandomRule();
//        return new RetryRule();
//    }
}
