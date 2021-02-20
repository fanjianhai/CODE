package com.xiaofan;

import com.xiaofan.dto.CustomerDto;
import com.xiaofan.mapper.CustomerMapper;
import com.xiaofan.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Springboot13MapstructApplication {

    // 注入Mapper
    @Autowired
    private CustomerMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(Springboot13MapstructApplication.class, args);
    }

    @GetMapping("/test")
    public CustomerDto test() {
        Customer customer = new Customer(1L, "zhangsan", true);
        CustomerDto customerDto = mapper.toCustomerDto(customer);
        return customerDto;
    }
}
