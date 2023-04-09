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
public class ChengjiVo extends PageVo{


    /**
     * id
     */
    private Long id;

    /**
     * 学生姓名
     */
    private String stuname;
    private String pingjunfen;
    private String jigelv;

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
