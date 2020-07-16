package com.dhh.bookkeeper.bookkeeper.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import com.dhh.bookkeeper.bookkeeper.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/userInfoList")
    public List<UserInfo> userInfoList(){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name","小丁");
        return userInfoService.list(queryWrapper);
    }
}

