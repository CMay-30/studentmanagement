package com.tw.vo;

import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjw
 * @since 2022-09-02
 */
@Data
public class MenuVo {


    /**
     * id
     */
    private Long id;

    /**
     * 菜单名
     */
    //随便鞋垫不然提交不上去
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
     * 角色0是用户1是管理员
     */
    private String role;


}
