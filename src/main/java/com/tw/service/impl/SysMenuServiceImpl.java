package com.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tw.dao.SysMenuMapper;
import com.tw.entity.Menu;
import com.tw.menu.MenuTree;
import com.tw.menu.MenuUtils;
import com.tw.service.SysMenuService;
import com.tw.utils.CopyUtil;
import com.tw.vo.MenuVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-11-23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, Menu> implements SysMenuService {
    @Resource
    private SysMenuMapper menuMapper;

    @Override
    public List<MenuUtils> getList(MenuVo menuVo) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Menu::getRole,menuVo.getRole());
        List<Menu> sysMenuList = menuMapper.selectList(queryWrapper);
        List<MenuUtils> menuList = CopyUtil.copyList(sysMenuList, MenuUtils.class);
        MenuTree menuTree =new MenuTree(menuList);
        menuList=menuTree.builTree();
        return menuList;
    }
}
