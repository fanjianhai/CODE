package com.xiaofan.mapper;

import com.xiaofan.dto.CustomerDto;
import com.xiaofan.format.BooleanStrFormat;
import com.xiaofan.pojo.Customer;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private BooleanStrFormat booleanStrFormat;

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setCustomerName( customer.getName() );
        customerDto.setDisable( booleanStrFormat.toStr( customer.getIsDisable() ) );

        return customerDto;
    }
}
