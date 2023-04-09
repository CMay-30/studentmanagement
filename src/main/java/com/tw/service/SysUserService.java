package com.tw.service;

import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tw.vo.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
public interface SysUserService extends IService<SysUser> {

    UserVo login(UserVo vo, CommonDto<UserVo> commonDto);

    UserVo register(UserVo vo, CommonDto<UserVo> commonDto);

    PageDto<SysUser> getList(UserVo vo);

    void save(UserVo vo);

    void delete(Long id);

    List<SysUser> select(UserVo userVo);
}
