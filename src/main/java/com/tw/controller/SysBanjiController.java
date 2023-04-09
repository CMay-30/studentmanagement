package com.tw.controller;


import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysBanji;
import com.tw.entity.SysUser;
import com.tw.service.SysBanjiService;
import com.tw.service.SysUserService;
import com.tw.vo.BanjiVo;
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
@RequestMapping("/sysBanji")
public class SysBanjiController {

    @Resource
    private SysBanjiService service;

    @GetMapping("/getlist")
    public CommonDto list(BanjiVo vo){
        CommonDto<PageDto<SysBanji>> commonDto = new CommonDto<>();
        PageDto<SysBanji> list = service.getList(vo);
        commonDto.setContent(list);
        return commonDto;
    }




    @PostMapping("/save")
    public CommonDto save(@RequestBody BanjiVo vo){
        CommonDto<SysBanji> commonDto = new CommonDto<>();
        service.save(vo);
        return commonDto;
    }

    @DeleteMapping("/delete/{id}")
    public CommonDto delete(@PathVariable Long id){
        CommonDto<BanjiVo> commonDto = new CommonDto<>();
        service.delete(id);
        return commonDto;
    }

}

