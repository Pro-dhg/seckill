package com.hg.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RateLimitController
 * @Author dhg
 * @Version 1.0
 * @Date 2024/4/24 10:41
 * @Description:
 *  高并发实在处理不了了，就只能是限流了～
 *  在调试过程中，我们可以将限流数10改为0.1，代表10秒执行一个服务
 *  当我们在多次调用limit接口的时候，我们的服务第一次会成功，剩下的几次，10秒之内不会成功，直到超过10秒，服务才会执行成功
 */

@RestController
@RequestMapping("/rate")
public class RateLimitController {

    //基于令牌桶算法的限流实现类,代表1秒执行10个任务
    RateLimiter rateLimiter = RateLimiter.create(10);

    @PostMapping("/limit")
    public String demo() {
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            return "执行失败，在规定时间1s内，没有获取许可";
        }

        return "执行成功" ;
    }


}
