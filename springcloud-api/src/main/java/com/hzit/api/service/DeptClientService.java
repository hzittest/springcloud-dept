package com.hzit.api.service;


import com.hzit.api.bean.Dept;
import com.hzit.api.factoy.DeptClientServiceFallbackFactoy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactoy.class)
public interface DeptClientService {

    /**
     *  路径 和提供者保持一致
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept);

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();

}
