package com.dhh.bookkeeper.bookkeeper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
