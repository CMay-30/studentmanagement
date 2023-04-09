package com.tw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysUser;
import com.tw.dao.SysUserMapper;
import com.tw.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tw.utils.CopyUtil;
import com.tw.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private SysUserMapper mapper;


    @Override
    public UserVo login(UserVo vo, CommonDto<UserVo> commonDto) {
        //通过前端传来的用户名去查询数据
        SysUser userDb = selectByUserName(vo.getUsername());
        //查看是否为空,如果为空就提示用户名不存在或密码不正确
        if(ObjectUtils.isEmpty(userDb)){
            commonDto.setMessage("用户不存在或密码不正确");
            commonDto.setSuccess(false);
        }else {
            //密码一致 登录成功
            if(userDb.getPassword().equals(vo.getPassword())){
                UserVo userVo1 = CopyUtil.copy(userDb, UserVo.class);
                return userVo1;
            }else {
                //密码不对
                commonDto.setMessage("用户不存在或密码不正确");
                commonDto.setSuccess(false);
            }
        }
        return vo;
    }

    @Override
    public UserVo register(UserVo vo, CommonDto<UserVo> commonDto) {
        SysUser user = CopyUtil.copy(vo, SysUser.class);
        if(ObjectUtils.isEmpty(vo.getId())){
            SysUser userDb = selectByUserName(vo.getUsername());
            if(ObjectUtils.isEmpty(userDb)){
//                新增
                mapper.insert(user);
            }else {
//                用户名已存在
                commonDto.setSuccess(false);
                commonDto.setMessage("登录名已存在");
            }
        }
        return vo;
    }

    /**
     * 查询用户名是否存在
     */
    public SysUser selectByUserName(String userName){
        //构造条件
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        //根据传来的用户名去数据库查询
        wrapper.lambda().eq(SysUser::getUsername,userName);
        //查询成功返回数据
        List<SysUser> userList = mapper.selectList(wrapper);
        //如果为空就说明没有这个用户名,就可以注册
        if(CollectionUtils.isEmpty(userList)){
            return null;
            //如果有就返回所有信息
        }else {
            return userList.get(0);
        }
    }


    @Override
    public PageDto<SysUser> getList(UserVo vo) {
        //创造构造方法
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getId())){
            queryWrapper.lambda().like(SysUser::getId,vo.getId());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getRole())){
            queryWrapper.lambda().eq(SysUser::getRole,vo.getRole());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getUsername())){
            queryWrapper.lambda().eq(SysUser::getUsername,vo.getUsername());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getName())){
            queryWrapper.lambda().like(SysUser::getName,vo.getName());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getClassess())){
            queryWrapper.lambda().like(SysUser::getClassess,vo.getClassess());
        }
        //判断前端是否传来参数,如果有就增加这个构造条件
        if(!org.springframework.util.ObjectUtils.isEmpty(vo.getSex())){
            queryWrapper.lambda().like(SysUser::getSex,vo.getSex());
        }
        Page<SysUser> page = new Page<>(vo.getPage(), vo.getSize());
        IPage<SysUser> userEntityIPage = mapper.selectPage(page, queryWrapper);
        PageDto<SysUser> pageResp = new PageDto<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void save(UserVo vo) {
        SysUser cunshujukudeshuju = CopyUtil.copy(vo, SysUser.class);
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

    @Override
    public List<SysUser> select(UserVo userVo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(!org.springframework.util.ObjectUtils.isEmpty(userVo.getId())){
            queryWrapper.lambda().like(SysUser::getId,userVo.getId());
        }
        if(!org.springframework.util.ObjectUtils.isEmpty(userVo.getName())){
            queryWrapper.lambda().like(SysUser::getName,userVo.getName());
        }
        return  mapper.selectList(queryWrapper);
    }

}
