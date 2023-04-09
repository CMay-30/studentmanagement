package com.tw.controller;


import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysCourse;
import com.tw.entity.SysUser;
import com.tw.service.SysCourseService;
import com.tw.service.SysUserService;
import com.tw.vo.CourseVo;
import com.tw.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@RestController
@RequestMapping("/sysCourse")
public class SysCourseController {

    @Resource
    private SysCourseService service;

    @GetMapping("/getlist")
    public CommonDto list(CourseVo vo){
        CommonDto<PageDto<SysCourse>> commonDto = new CommonDto<>();
        PageDto<SysCourse> list = service.getList(vo);
        commonDto.setContent(list);
        return commonDto;
    }


    @PostMapping("/save")
    public CommonDto save(@RequestBody CourseVo vo){
        CommonDto<SysCourse> commonDto = new CommonDto<>();
        service.save(vo);
        return commonDto;
    }

    @DeleteMapping("/delete/{id}")
    public CommonDto delete(@PathVariable Long id){
        CommonDto<CourseVo> commonDto = new CommonDto<>();
        service.delete(id);
        return commonDto;
    }

}

