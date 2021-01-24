package com.xiaofan.springcloud.service;

import com.xiaofan.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

// 降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            public Dept queryById(Long id) {
                return new Dept(id, "降级", "降级");
            }

            public List<Dept> queryAll() {
                return null;
            }

            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
