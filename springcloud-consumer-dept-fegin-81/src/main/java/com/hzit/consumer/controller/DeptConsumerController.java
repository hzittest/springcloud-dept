package com.hzit.consumer.controller;

import com.hzit.api.bean.Dept;
import com.hzit.api.service.DeptClientService;
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
    private DeptClientService deptClientService;


    @RequestMapping("/dept/list")
    public List<Dept> list() throws IOException {

        return deptClientService.list();
    }

    @RequestMapping("/dept/{deptno}")
    public Dept findById(@PathVariable Long deptno) throws IOException {
        return deptClientService.get(deptno);
    }


    @PostMapping("/dept/save")
    public Boolean save(@RequestBody Dept dept) {
        boolean add = deptClientService.add(dept);
        return add;
    }


}
