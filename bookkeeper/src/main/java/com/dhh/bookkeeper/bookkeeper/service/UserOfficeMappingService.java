package com.dhh.bookkeeper.bookkeeper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dhh.bookkeeper.bookkeeper.entity.UserOfficeMapping;

import java.util.List;

/**
 * <p>
 * 人员房间关联表 服务类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
public interface UserOfficeMappingService extends IService<UserOfficeMapping> {

    /**
     * 插入关联数据
     * @param userId
     * @param officeId
     */
    void insertMapping(Long userId,Long officeId);

    /**
     * 根据房间id查询关联数据
     */
    List<UserOfficeMapping> selectByOfficeId(Long officeId);

}
