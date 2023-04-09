package com.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tw.dao.SysUserMapper;
import com.tw.dto.PageDto;
import com.tw.entity.SysBanji;
import com.tw.dao.SysBanjiMapper;
import com.tw.entity.SysUser;
import com.tw.service.SysBanjiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tw.utils.CopyUtil;
import com.tw.vo.BanjiVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Service
public class SysBanjiServiceImpl extends ServiceImpl<SysBanjiMapper, SysBanji> implements SysBanjiService {

    @Resource
    private SysBanjiMapper mapper;

    @Override
    public PageDto<SysBanji> getList(BanjiVo vo) {
        //创造构造方法
        QueryWrapper<SysBanji> queryWrapper = new QueryWrapper<>();
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getId())){
            queryWrapper.lambda().eq(SysBanji::getId,vo.getId());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getBanji())){
            queryWrapper.lambda().like(SysBanji::getBanji,vo.getBanji());
        }
        Page<SysBanji> page = new Page<>(vo.getPage(), vo.getSize());
        IPage<SysBanji> userEntityIPage = mapper.selectPage(page, queryWrapper);
        PageDto<SysBanji> pageResp = new PageDto<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void save(BanjiVo vo) {
        SysBanji cunshujukudeshuju = CopyUtil.copy(vo, SysBanji.class);
        if(ObjectUtils.isEmpty(vo.getId())){
            mapper.insert(cunshujukudeshuju);
        }else {
            mapper.updateById(cunshujukudeshuju);
        }
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }
}
