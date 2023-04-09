package com.tw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
@TableName("sys_course")
public class SysCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程
     */
    private String course;

    /**
     * 班级
     */
    private String banji;

    /**
     * 老师
     */
    private String teacher;

    /**
     * 老师id
     */
    private String userids;

    /**
     * 上课时间
     */
    private String sktimes;

    /**
     * 上课日期
     */
    private Date skdate;


}
