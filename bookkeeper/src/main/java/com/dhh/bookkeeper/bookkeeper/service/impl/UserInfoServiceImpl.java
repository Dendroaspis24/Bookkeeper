package com.dhh.bookkeeper.bookkeeper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import com.dhh.bookkeeper.bookkeeper.mapper.UserInfoMapper;
import com.dhh.bookkeeper.bookkeeper.request.CreateOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.UserInfoParam;
import com.dhh.bookkeeper.bookkeeper.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Override
    public Long checkUserinfo(UserInfoParam param) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", param.getOpenId());
        UserInfo userInfo = baseMapper.selectOne(queryWrapper);
        UserInfo build = UserInfo.builder().openId(param.getOpenId()).userName(param.getUserName()).wxCode(param.getWxCode()).lastLoginTime(new Date()).build();
        if (Objects.isNull(userInfo)) {
            baseMapper.insert(build);
        } else {
            baseMapper.update(build, queryWrapper);
        }
        return Objects.isNull(userInfo)? build.getUserId():userInfo.getUserId();
    }
}
