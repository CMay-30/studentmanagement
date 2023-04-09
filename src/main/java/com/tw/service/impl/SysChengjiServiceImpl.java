package com.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tw.dao.SysUserMapper;
import com.tw.dto.PageDto;
import com.tw.entity.SysChengji;
import com.tw.dao.SysChengjiMapper;
import com.tw.entity.SysUser;
import com.tw.service.SysChengjiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tw.service.SysUserService;
import com.tw.utils.CopyUtil;
import com.tw.vo.ChengjiVo;
import com.tw.vo.UserVo;
import com.tw.vo.excelx.ChengjiEXVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@Service
public class SysChengjiServiceImpl extends ServiceImpl<SysChengjiMapper, SysChengji> implements SysChengjiService {

    @Resource
    private SysChengjiMapper mapper;

    @Resource
    private SysUserService userService;

    @Override
    public PageDto<SysChengji> getList(ChengjiVo vo) {
        //创造构造方法
        QueryWrapper<SysChengji> queryWrapper = new QueryWrapper<>();
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getId())){
            queryWrapper.lambda().eq(SysChengji::getId,vo.getId());
        }
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getStuname())){
            queryWrapper.lambda().like(SysChengji::getStuname,vo.getStuname());
        }
        Page<SysChengji> page = new Page<>(vo.getPage(), vo.getSize());
        IPage<SysChengji> userEntityIPage = mapper.selectPage(page, queryWrapper);
        PageDto<SysChengji> pageResp = new PageDto<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void save(ChengjiVo vo) {
        SysChengji cunshujukudeshuju = CopyUtil.copy(vo, SysChengji.class);
        if(ObjectUtils.isEmpty(vo.getId())){
            UserVo userVo = new UserVo();
            userVo.setName(userVo.getName());
            List<SysUser> userVoList=  userService.select(userVo);
            cunshujukudeshuju.setBanji(userVoList.get(0).getClassess());
            mapper.insert(cunshujukudeshuju);
        }else {
            mapper.updateById(cunshujukudeshuju);
        }
    }
    @Override
    public List<ChengjiVo> selectCountGroupByName(ChengjiVo vo) {
        //创造构造方法
        List<ChengjiVo> userEntityIPage = mapper.selectCountGroupByName(vo.getBanji());
        return userEntityIPage;
    }

    @Override
    public List<ChengjiEXVo> exportMemberList() {
        List<ChengjiEXVo> userExportVOList = mapper.exportMemberList();
        return userExportVOList;
    }
    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }
}
