package com.dhh.bookkeeper.bookkeeper.controller;


import com.dhh.bookkeeper.bookkeeper.entity.OfficeInfo;
import com.dhh.bookkeeper.bookkeeper.request.CreateOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.JoinOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.QueryOfficeParam;
import com.dhh.bookkeeper.bookkeeper.service.OfficeInfoService;
import com.dhh.bookkeeper.utils.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 房间信息表 前端控制器
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@RestController
@RequestMapping("/officeInfo")
@Api("房间信息")
public class OfficeInfoController {

@Autowired
private OfficeInfoService officeInfoService;
    /**
     * 创建房间
     * @return
     */
    @ApiOperation("创建房间")
    @PostMapping("/createOffice")
    public RespResult<String> createOffice(@Validated  @RequestBody @ApiParam CreateOfficeParam param){
        return RespResult.success(officeInfoService.createOffice(param));
    }

    /**
     * 查询房间列表
     */
    @ApiOperation("查询房间列表")
    @PostMapping("/officeList")
    public RespResult<List<OfficeInfo>> officeList(@Validated  @RequestBody @ApiParam QueryOfficeParam param){
        return RespResult.success(officeInfoService.officeList(param));
    }

    /**
     * 加入房间
     */
    @ApiOperation("加入房间")
    @PostMapping("/joinOffice")
    public RespResult<String> joinOffice(@Validated  @RequestBody @ApiParam JoinOfficeParam param){
        return RespResult.success(officeInfoService.joinOffice(param));
    }
}

