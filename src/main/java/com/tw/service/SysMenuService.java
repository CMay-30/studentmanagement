package com.tw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tw.entity.Menu;
import com.tw.menu.MenuUtils;
import com.tw.vo.MenuVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-11-23
 */
public interface SysMenuService extends IService<Menu> {

    List<MenuUtils> getList(MenuVo menuVo);
}
