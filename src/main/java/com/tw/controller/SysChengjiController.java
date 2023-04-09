package com.tw.controller;


import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.tw.dto.CommonDto;
import com.tw.dto.PageDto;
import com.tw.entity.SysChengji;
import com.tw.entity.SysUser;
import com.tw.service.SysChengjiService;
import com.tw.service.SysUserService;
import com.tw.vo.ChengjiVo;
import com.tw.vo.UserVo;
import com.tw.vo.excelx.ChengjiEXVo;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-04-08
 */
@RestController
@RequestMapping("/sysChengji")
public class SysChengjiController {

    @Resource
    private SysChengjiService service;

    @GetMapping("/getlist")
    public CommonDto list(ChengjiVo vo){
        CommonDto<PageDto<SysChengji>> commonDto = new CommonDto<>();
        PageDto<SysChengji> list = service.getList(vo);
        commonDto.setContent(list);
        return commonDto;
    }


    @PostMapping("/save")
    public CommonDto save(@RequestBody ChengjiVo vo){
        CommonDto<SysChengji> commonDto = new CommonDto<>();
        service.save(vo);
        return commonDto;
    }

    @DeleteMapping("/delete/{id}")
    public CommonDto delete(@PathVariable Long id){
        CommonDto<ChengjiVo> commonDto = new CommonDto<>();
        service.delete(id);
        return commonDto;
    }

    @GetMapping("/selectCountGroupByName")
    public CommonDto selectCountGroupByName(ChengjiVo vo){
        CommonDto<List<ChengjiVo>> commonDto = new CommonDto<>();
        List<ChengjiVo> list = service.selectCountGroupByName(vo);
        commonDto.setContent(list);
        return commonDto;
    }


    @GetMapping("/exportMemberList")
    public void exportMemberList(ModelMap map,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        List<ChengjiEXVo> memberList = new ArrayList<>();
        ChengjiEXVo user1 = new ChengjiEXVo();
        List<ChengjiEXVo> userExportVOList = service.exportMemberList();
        //memberList.add(userExportVOList);
        ExportParams params = new ExportParams("学生成绩管理系统", "成绩列表", ExcelType.XSSF);
        map.put(NormalExcelConstants.DATA_LIST, userExportVOList);
        map.put(NormalExcelConstants.CLASS, ChengjiEXVo.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "memberList");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }


}

