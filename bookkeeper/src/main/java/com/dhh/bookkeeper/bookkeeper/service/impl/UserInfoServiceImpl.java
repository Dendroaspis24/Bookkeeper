package com.dhh.bookkeeper.bookkeeper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import com.dhh.bookkeeper.bookkeeper.mapper.UserInfoMapper;
import com.dhh.bookkeeper.bookkeeper.service.UserInfoService;
import org.springframework.stereotype.Service;

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

}
