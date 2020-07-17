package com.dhh.bookkeeper.bookkeeper.service.impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhh.bookkeeper.bookkeeper.Enum.ErrorCodeEnum;
import com.dhh.bookkeeper.bookkeeper.Enum.OfficeStatusEnum;
import com.dhh.bookkeeper.bookkeeper.entity.OfficeInfo;
import com.dhh.bookkeeper.bookkeeper.entity.UserInfo;
import com.dhh.bookkeeper.bookkeeper.entity.UserOfficeMapping;
import com.dhh.bookkeeper.bookkeeper.mapper.OfficeInfoMapper;
import com.dhh.bookkeeper.bookkeeper.request.CreateOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.JoinOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.QueryOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.UserInfoParam;
import com.dhh.bookkeeper.bookkeeper.service.OfficeInfoService;
import com.dhh.bookkeeper.bookkeeper.service.UserInfoService;
import com.dhh.bookkeeper.bookkeeper.service.UserOfficeMappingService;
import com.dhh.bookkeeper.utils.DBKRuntimeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 房间信息表 服务实现类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
@Service
public class OfficeInfoServiceImpl extends ServiceImpl<OfficeInfoMapper, OfficeInfo> implements OfficeInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserOfficeMappingService userOfficeMappingService;

    @Override
    public String createOffice(CreateOfficeParam param) {
        //获取用户信息
        UserInfoParam userInfoParam = new UserInfoParam();
        BeanUtils.copyProperties(param,userInfoParam);
        Long userId = userInfoService.checkUserinfo(userInfoParam);
        //初始化房间信息
        String officeNum = initOffice(userId);
        return "创建成功！房间号"+officeNum;
    }

    private String initOffice(Long userId){
        OfficeInfo officeInfo = OfficeInfo.builder().empCount(1).creatorId(userId).officeNum(generateNum()).officeStatus(OfficeStatusEnum.开启中_1.value()).createTime(new Date()).build();
        baseMapper.insert(officeInfo);
        //建立创建者与房间关联关系
        userOfficeMappingService.insertMapping(userId,officeInfo.getOfficeId());
        return officeInfo.getOfficeNum();
    }


    private String generateNum() {
        return TypeUtils.castToString((Math.random() * 9 + 1) * 100000).subSequence(0, 6).toString();
    }

    @Override
    public List<OfficeInfo> officeList(QueryOfficeParam param) {
        if(Objects.isNull(param)){
            return new ArrayList<>();
        }
        QueryWrapper<OfficeInfo> queryWrapper = new QueryWrapper();
        queryWrapper.eq("office_status",param.getOfficeStatus());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public String joinOffice(JoinOfficeParam param) {
        //获取房间信息
        QueryWrapper<OfficeInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("office_num",param.getOfficeNum());
        OfficeInfo officeInfo = baseMapper.selectOne(queryWrapper);
        DBKRuntimeException.ifThrow(Objects.isNull(officeInfo),ErrorCodeEnum.数据不存在,"房间号");
        DBKRuntimeException.ifThrow(Objects.equals(officeInfo.getOfficeStatus(),OfficeStatusEnum.已关闭_0.value()), ErrorCodeEnum.该房间号已关闭);


        //获取用户信息
        UserInfoParam userInfoParam = new UserInfoParam();
        BeanUtils.copyProperties(param,userInfoParam);
        Long userId = userInfoService.checkUserinfo(userInfoParam);
        //加入房间,创建关联关系
        userOfficeMappingService.insertMapping(userId,officeInfo.getOfficeId());

        //刷新房间主数据
        flushOffice(officeInfo.getOfficeId());
        return "加入房间成功！,房间号"+officeInfo.getOfficeNum();
    }


    /**
     * 刷新房间主数据
     */
    private void flushOffice(Long officeId){
        OfficeInfo officeInfo = baseMapper.selectById(officeId);
        DBKRuntimeException.ifThrow(Objects.isNull(officeInfo),ErrorCodeEnum.数据不存在,"房间号");
        //获取关联数据
        List<UserOfficeMapping> userOfficeMappings = userOfficeMappingService.selectByOfficeId(officeId);
        officeInfo.setEmpCount(userOfficeMappings.size());
        baseMapper.updateById(officeInfo);
    }
}
