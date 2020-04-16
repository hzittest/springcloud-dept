package com.hzit.consumer.controller;

import com.hzit.api.bean.Dept;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptConsumerController {




    @Autowired
    private RestTemplate restTemplate;

    //SPRINGCLOUD-DEPT:注册在Eureka服务的名称，可以直接通过名称取获取
    String baseUrl = "http://SPRINGCLOUD-DEPT/";

    @RequestMapping("/dept/list")
    public List<Dept> list() throws IOException {

        //远程调用:
        // - rpc:远程过程调用(dubbo框架)
        // - http:
        //     -:HttpClient
        //     -:RestTemplater 模板类，其实对HttpClient再次封装

        //HttpClient实现
        String url = baseUrl + "dept/list";
//        HttpClient ie = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet(url);
//        HttpResponse httpResponse = ie.execute(httpGet);
//        HttpEntity entity = httpResponse.getEntity();
//        // StringEntity entity1 = new StringEntity(entity.toString(), "UTF-8");
//        String string = EntityUtils.toString(entity, "utf-8");

        //字符串：
        //推荐使用RestTemplater

        List<Dept> deptList = restTemplate.getForObject(url, List.class);

        //entity:除了获取对象之外，还可以获取状态码，头部等信息
        ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);


        return deptList;
    }

    @RequestMapping("/dept/{deptno}")
    public Dept findById(@PathVariable Integer deptno) throws IOException {
        Dept dept = restTemplate.getForObject(baseUrl + "/dept/get/" + deptno, Dept.class);
        return dept;
    }


    @PostMapping("/dept/save")
    public Boolean save(@RequestBody Dept dept) {
        String url = baseUrl + "dept/add";
        Boolean aBoolean = restTemplate.postForObject(url, dept, boolean.class);
        return aBoolean;
    }


}
