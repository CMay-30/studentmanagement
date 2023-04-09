package com.tw.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Data
public class CourseVo extends PageVo {


    /**
     * id
     */
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
    private String skdatecr;


}
