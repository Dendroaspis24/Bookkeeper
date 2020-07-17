package com.dhh.bookkeeper.bookkeeper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dhh.bookkeeper.bookkeeper.entity.OfficeInfo;
import com.dhh.bookkeeper.bookkeeper.request.CreateOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.JoinOfficeParam;
import com.dhh.bookkeeper.bookkeeper.request.QueryOfficeParam;

import java.util.List;

/**
 * <p>
 * 房间信息表 服务类
 * </p>
 *
 * @author dinghaohui
 * @since 2020-07-16
 */
public interface OfficeInfoService extends IService<OfficeInfo> {

    /**
     * 创建房间
     * @param param
     * @return
     */
    String createOffice(CreateOfficeParam param);

    /**
     * 查询房间列表
     */
    List<OfficeInfo> officeList(QueryOfficeParam param);

    /**
     * 加入房间
     */
    String joinOffice(JoinOfficeParam param);
}
