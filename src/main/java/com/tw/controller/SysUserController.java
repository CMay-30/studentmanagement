package com.tw.controller;


import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysUser;
import com.tw.service.SysUserService;
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
@RequestMapping("/user")
public class SysUserController {
    @Resource
    private SysUserService service;

    @PostMapping("/login")
    public CommonDto login(@RequestBody UserVo vo){
        CommonDto<UserVo> commonDto = new CommonDto<>();
        UserVo login = service.login(vo, commonDto);
        commonDto.setContent(login);
        return commonDto;
    }

    @PostMapping("/register")
    public CommonDto register(@RequestBody UserVo vo){
        CommonDto<UserVo> commonDto = new CommonDto<>();
        UserVo login = service.register(vo, commonDto);
        commonDto.setContent(login);
        return commonDto;
    }


    @GetMapping("/getlist")
    public CommonDto list(UserVo vo){
        CommonDto<PageDto<SysUser>> commonDto = new CommonDto<>();
        PageDto<SysUser> list = service.getList(vo);
        commonDto.setContent(list);
        return commonDto;
    }




    @PostMapping("/save")
    public CommonDto save(@RequestBody UserVo vo){
        CommonDto<SysUser> commonDto = new CommonDto<>();
        service.save(vo);
        return commonDto;
    }

    @DeleteMapping("/delete/{id}")
    public CommonDto delete(@PathVariable Long id){
        CommonDto<UserVo> commonDto = new CommonDto<>();
        service.delete(id);
        return commonDto;
    }
}

