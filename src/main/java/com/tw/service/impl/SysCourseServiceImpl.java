package com.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tw.dao.SysUserMapper;
import com.tw.dto.PageDto;
import com.tw.entity.SysCourse;
import com.tw.dao.SysCourseMapper;
import com.tw.entity.SysUser;
import com.tw.service.SysCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tw.service.SysUserService;
import com.tw.utils.CopyUtil;
import com.tw.vo.CourseVo;
import com.tw.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
public class SysCourseServiceImpl extends ServiceImpl<SysCourseMapper, SysCourse> implements SysCourseService {

    @Resource
    private SysCourseMapper mapper;

    @Resource
    private SysUserService userService;

    @Override
    public PageDto<SysCourse> getList(CourseVo vo) {
        //创造构造方法
        QueryWrapper<SysCourse> queryWrapper = new QueryWrapper<>();
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getId())){
            queryWrapper.lambda().eq(SysCourse::getId,vo.getId());
        }
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getCourse())){
            queryWrapper.lambda().like(SysCourse::getCourse,vo.getCourse());
        }


        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getSkdatecr())){
            String createTimeStr = vo.getSkdatecr();
            Date createTime = Date.from(LocalDate.parse(createTimeStr).atStartOfDay(ZoneId.systemDefault()).toInstant());
            queryWrapper.lambda().eq(SysCourse::getSkdate, createTime);
            //queryWrapper.lambda().like(SysCourse::getSkdate,vo.getSkdatecr());
        }

        Page<SysCourse> page = new Page<>(vo.getPage(), vo.getSize());
        IPage<SysCourse> userEntityIPage = mapper.selectPage(page, queryWrapper);
        PageDto<SysCourse> pageResp = new PageDto<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void save(CourseVo vo) {
        SysCourse cunshujukudeshuju = CopyUtil.copy(vo, SysCourse.class);
        if(ObjectUtils.isEmpty(vo.getId())){
            UserVo userVo = new UserVo();
            userVo.setId(Long.valueOf(vo.getUserids()));
            List<SysUser> userVoList=  userService.select(userVo);
            cunshujukudeshuju.setTeacher(userVoList.get(0).getName());
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
