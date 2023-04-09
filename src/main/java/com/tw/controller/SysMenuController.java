package com.tw.controller;


import com.tw.dto.CommonDto;
import com.tw.menu.MenuUtils;
import com.tw.service.SysMenuService;
import com.tw.vo.MenuVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-11-23
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Resource
    private SysMenuService MenuService;

    @GetMapping("/getMenulist")
    public CommonDto list(MenuVo menuVo){
        CommonDto<List<MenuUtils>> commonDto = new CommonDto<>();
        List<MenuUtils> list = MenuService.getList(menuVo);
        commonDto.setContent(list);
        return commonDto;
    }
}

