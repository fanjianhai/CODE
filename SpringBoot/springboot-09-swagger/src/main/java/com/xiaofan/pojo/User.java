package com.xiaofan.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="",description="用户对象user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="用户名",example="xingguo")
    private String username;
    @ApiModelProperty(value="状态",required=true)
    private Integer state;
    private String password;
    private String nickName;
    private Integer isDeleted;

    @ApiModelProperty(value="id数组",hidden=true)
    private String[] ids;
    private List<String> idList;
    //省略get/set
}
