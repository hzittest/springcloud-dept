package com.hzit.springcloud.provider.controller;

import com.hzit.api.bean.Dept;
import com.hzit.springcloud.provider.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private IDeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id).setLoc("loc_8001");
        if(dept ==null)
        {
            throw  new RuntimeException();
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }


    @ResponseBody
    @GetMapping("/provider/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println(list);
        List<ServiceInstance> insList = discoveryClient.getInstances("SPRINGCLOUD-DEPT");
        for (ServiceInstance si : insList) {
            System.out.println(si.getHost() + "," + si.getServiceId() + "," + si.getPort() + "," + si.getUri() + ","
                    + si.getMetadata());
        }
        return this.discoveryClient;
    }


}
