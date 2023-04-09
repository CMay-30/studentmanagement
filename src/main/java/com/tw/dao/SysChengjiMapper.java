package com.tw.dao;

import com.tw.entity.SysChengji;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tw.vo.ChengjiVo;
import com.tw.vo.excelx.ChengjiEXVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
public interface SysChengjiMapper extends BaseMapper<SysChengji> {


    @Select("<script>" +
            "SELECT course, AVG(scope) AS pingjunfen, SUM(scope >= 60) / COUNT(*) AS jigelv " +
            "FROM sys_chengji " +
            "<if test='banji != null'> " +
            "WHERE banji = #{banji} " +
            "</if> "+
            "GROUP BY course "+
            "</script>")
    List<ChengjiVo> selectCountGroupByName(@Param("banji") String banji);

    @Select("SELECT * FROM `sys_chengji`")
    List<ChengjiEXVo> exportMemberList();
}
