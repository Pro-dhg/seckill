package com.hg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Author dhg
 * @Version 1.0
 * @Date 2024/4/25 15:12
 * @Description: Restful 交互
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/prod/{pid}")
    public String order(@PathVariable("pid") Integer pid) {

        // 假设服务的地址是下面的，而且而且返回的结果为String，那么就会返回order的信息
        String order = restTemplate.getForObject("http://localhost:8081/product/" + pid, String.class);
        return order;
    }
}
