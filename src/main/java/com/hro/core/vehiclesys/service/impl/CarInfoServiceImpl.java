package com.hro.core.vehiclesys.service.impl;

import com.hro.core.vehiclesys.dao.CarInfoDao;
import com.hro.core.vehiclesys.request.EditCarInfoReq;
import com.hro.core.vehiclesys.response.CommonWrapper;
import com.hro.core.vehiclesys.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoDao carInfoDao;

    @Override
    public CommonWrapper addInfo(EditCarInfoReq req) {
        CommonWrapper wrapper = new CommonWrapper();

        return wrapper;
    }
}
