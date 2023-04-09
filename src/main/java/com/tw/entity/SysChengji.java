package com.tw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_chengji")
public class SysChengji implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生姓名
     */
    private String stuname;

    /**
     * 课程
     */
    private String course;

    /**
     * 授课老师
     */
    private String teacher;

    /**
     * 成绩
     */
    private String scope;

    /**
     * 班级
     */
    private String banji;


}
