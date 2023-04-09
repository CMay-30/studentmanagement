package com.tw.entity;

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
 * @since 2023-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名
     */
    private String authName;

    /**
     * 父id
     */
    private String pid;

    /**
     * 路径
     */
    private String path;

    /**
     * 角色 0是用户1是管理员
     */
    private String role;


}
