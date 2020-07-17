package com.dhh.bookkeeper.bookkeeper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhh.bookkeeper.bookkeeper.entity.UserOfficeMapping;
import com.dhh.bookkeeper.bookkeeper.mapper.UserOfficeMappingMapper;
import com.dhh.bookkeeper.bookkeeper.service.UserOfficeMappingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 人员房间关联表 服务实现类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Service
public class UserOfficeMappingServiceImpl extends ServiceImpl<UserOfficeMappingMapper, UserOfficeMapping> implements UserOfficeMappingService {


    @Override
    public void insertMapping(Long userId, Long officeId) {
        if(Objects.isNull(userId) || Objects.isNull(officeId)){
            return;
        }
        //TODO 判断该人员是否在房间中

        UserOfficeMapping mapping = UserOfficeMapping.builder().officeId(officeId).userId(userId).build();
        baseMapper.insert(mapping);
    }

    @Override
    public List<UserOfficeMapping> selectByOfficeId(Long officeId) {
        if(Objects.isNull(officeId)){
            return Collections.emptyList();
        }
        QueryWrapper<UserOfficeMapping> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("office_id",officeId);
        return baseMapper.selectList(queryWrapper);
    }
}
