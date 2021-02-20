package com.xiaofan.mapper;

import com.xiaofan.dto.CustomerDto;
import com.xiaofan.format.BooleanStrFormat;
import com.xiaofan.pojo.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// 这里主要是这个componentModel 属性，它的值就是当前要使用的依赖注入的环境
@Mapper(componentModel = "spring", uses = { BooleanStrFormat.class})
public interface CustomerMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto toCustomerDto(Customer customer);
}
