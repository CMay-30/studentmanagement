package com.tw.service;

import com.tw.dto.PageDto;
import com.tw.entity.SysBanji;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tw.vo.BanjiVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
public interface SysBanjiService extends IService<SysBanji> {

    PageDto<SysBanji> getList(BanjiVo vo);

    void save(BanjiVo vo);

    void delete(Long id);
}
