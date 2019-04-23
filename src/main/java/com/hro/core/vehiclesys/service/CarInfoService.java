package com.hro.core.vehiclesys.service;

import com.hro.core.vehiclesys.request.CarInfoEditReq;
import com.hro.core.vehiclesys.response.CommonWrapper;
import com.hro.core.vehiclesys.response.PageSearchWrapper;

/**
 * 车辆信息业务处理类
 */
public interface CarInfoService {

    /**
     * 添加车辆信息
     * @param req
     * @return
     */
    CommonWrapper addInfo(CarInfoEditReq req);

    /**
     * 更新车辆信息
     * @param req
     * @return
     */
    CommonWrapper updateInfo(CarInfoEditReq req);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param beginTime
     * @param endTime
     * @param carNo
     * @return
     */
    PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String carNo);
}
