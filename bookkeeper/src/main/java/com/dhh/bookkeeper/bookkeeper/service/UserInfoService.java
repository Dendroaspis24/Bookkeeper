package com.dhh.bookkeeper.bookkeeper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import com.dhh.bookkeeper.bookkeeper.request.CreateOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.UserInfoParam;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 校验openid在用户表存不存在，不存在则插入数据，存在则更新数据
     * @param param
     * @return
     */
    Long checkUserinfo(UserInfoParam param);
}
