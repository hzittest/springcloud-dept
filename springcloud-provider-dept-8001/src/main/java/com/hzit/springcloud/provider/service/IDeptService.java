package com.hzit.springcloud.provider.service;

import com.hzit.api.bean.Dept;

import java.util.List;

public interface IDeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
