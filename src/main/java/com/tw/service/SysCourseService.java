package com.tw.service;

import com.tw.dto.PageDto;
import com.tw.entity.SysCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tw.vo.CourseVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
public interface SysCourseService extends IService<SysCourse> {

    PageDto<SysCourse> getList(CourseVo vo);

    void save(CourseVo vo);

    void delete(Long id);
}
