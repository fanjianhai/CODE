package com.xiaofan.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "老师实体")
public class Teacher {
    @ApiModelProperty(value="教师名",example="张老师")
    private String name;
    @ApiModelProperty(value="教师年龄",example="30")
    private int age;
    @ApiModelProperty(value="教师爱好", example = "['a','b']")
    private List<String> hobbies;
}
