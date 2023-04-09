package com.tw.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Data
public class UserVo extends PageVo {


    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 角色(0是学生,1是管理员，2是老师)
     */
    private String role;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 班级、授课班级
     */
    private String classess;

    /**
     * 职称
     */
    private String zhicheng;

    /**
     * 联系方式
     */
    private String phone;


}
