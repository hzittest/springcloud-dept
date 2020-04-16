package com.hzit.api.factoy;

import com.hzit.api.bean.Dept;
import com.hzit.api.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactoy implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                long l = id;
                int i = (int) l;
                return new Dept().setDeptno(i).setDname("没有找到数据").setLoc("not found data");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
