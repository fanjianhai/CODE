package com.xiaofan;

import com.xiaofan.domain.Role;
import com.xiaofan.domain.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-08T11:54:06+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRoleDto toUserRoleDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserRoleDto userRoleDto = new UserRoleDto();

        userRoleDto.setUserId( user.getId() );
        userRoleDto.setName( user.getUsername() );
        userRoleDto.setRoleName( userRoleRoleName( user ) );

        return userRoleDto;
    }

    private String userRoleRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String roleName = role.getRoleName();
        if ( roleName == null ) {
            return null;
        }
        return roleName;
    }
}
