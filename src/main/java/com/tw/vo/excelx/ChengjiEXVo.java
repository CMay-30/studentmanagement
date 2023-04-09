package com.tw.vo.excelx;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.tw.vo.PageVo;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Data
public class ChengjiEXVo {



    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名")
    private String stuname;


    /**
     * 课程
     */
    @Excel(name = "课程")
    private String course;



    /**
     * 成绩
     */
    @Excel(name = "成绩")
    private String scope;

    /**
     * 班级
     */
    @Excel(name = "班级")
    private String banji;


}
