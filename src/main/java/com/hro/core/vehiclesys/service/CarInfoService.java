package com.hro.core.vehiclesys.service;

import com.hro.core.vehiclesys.request.EditCarInfoReq;
import com.hro.core.vehiclesys.response.CommonWrapper;

/**
 * 车辆信息业务处理类
 */
public interface CarInfoService {

    /**
     * 添加车辆信息
     * @param req
     * @return
     */
    public CommonWrapper addInfo(EditCarInfoReq req);
}
