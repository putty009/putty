package com.chong.usermanage.Service;

import com.chong.usermanage.po.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.Future;

@Service
public class UserManageService {
    @Autowired
    RestTemplate restTemplate;

    /*同步执行*/
    /*当需要请求多个服务时，为了减少通信消耗，可以请求合并*/
    @HystrixCommand(fallbackMethod = "userFallback")
    public User sample(Integer id) {
        User body = restTemplate.getForObject("http://USER/user/sample/"+id, User.class);

        /*int sleepTime = new Random(47).nextInt(3000);
        System.out.println(sleepTime);
        try {
            Thread.sleep(sleepTime);
        }catch (Exception e) {}*/

        return body;
        //return restTemplate.getForEntity("http://USER-SERVICE/users?id={1}", List.class, StringUtils.join(ids,',')).getBody();
    }

    /*异步执行*/
    @HystrixCommand(fallbackMethod = "helloFallback")
    public Future<String> helloServiceAsync() {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://USER-SERVICE/hello", String.class).getBody();
            }
        };
    }


    /*@HystrixCommand(fallbackMethod = "helloFallback")
    public Future<User> selelctUser() {
        return restTemplate.getForEntity("http://USER-SERVICE/user/showUser", User.class).getBody();
    }*/



    /*TODO：服务调用会出现超时，后面再解决*/
    @HystrixCommand(fallbackMethod = "userFallback")
    public String userService() {
        //return restTemplate.getForEntity("http://USER-SERVICE/user/showUser?id={1}", String.class).getBody();
        System.out.println("consumer user");
        String body = restTemplate.getForEntity("http://USER-SERVICE/user", String.class).getBody();
        System.out.println(body);
        return body;
    }

    /*设置请求缓存*/
    /*在update操作中使用缓存清理@CacheRemove(commandKey="cacheTest")*/
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand()
    public String cacheTest(String key) throws InterruptedException {
        //return restTemplate.getForEntity("http://USER-SERVICE/user/showUser?id={1}", String.class).getBody();
        String body2 = restTemplate.getForEntity("http://USER-SERVICE/cacheTest/{1}", String.class, key).getBody();
        System.out.println(body2);

        int sleepTime = new Random(47).nextInt(3000);
        System.out.println(sleepTime);
        Thread.sleep(sleepTime);
        return body2;
    }

    /*获取缓存key的方法*/
    public String getCacheKey(String key) {
        return key;
    }

    /*指定降级策略*/
    public String helloFallback(String key, Throwable throwable) {
        System.out.println(throwable);
        return "error";
    }
    public User userFallback(Integer id, Throwable throwable) {
        System.out.println(throwable);
        return null;
    }
}
