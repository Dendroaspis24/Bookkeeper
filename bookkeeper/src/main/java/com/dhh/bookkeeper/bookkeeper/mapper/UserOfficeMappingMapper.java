package com.dhh.bookkeeper.bookkeeper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhh.bookkeeper.bookkeeper.entity.UserOfficeMapping;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 人员房间关联表 Mapper 接口
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Mapper
public interface UserOfficeMappingMapper extends BaseMapper<UserOfficeMapping> {

}
