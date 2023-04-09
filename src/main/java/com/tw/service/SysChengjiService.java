package com.tw.service;

import com.tw.dto.PageDto;
import com.tw.entity.SysChengji;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tw.vo.ChengjiVo;
import com.tw.vo.excelx.ChengjiEXVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
public interface SysChengjiService extends IService<SysChengji> {

    PageDto<SysChengji> getList(ChengjiVo vo);

    void save(ChengjiVo vo);

    void delete(Long id);

    List<ChengjiVo> selectCountGroupByName(ChengjiVo vo);

    List<ChengjiEXVo> exportMemberList();
}
