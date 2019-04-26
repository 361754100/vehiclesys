package com.hro.core.vehiclesys.service.impl;

import com.hro.core.vehiclesys.dao.CarInfoDao;
import com.hro.core.vehiclesys.dao.model.CarInfo;
import com.hro.core.vehiclesys.enums.ResultCodeEnum;
import com.hro.core.vehiclesys.request.CarInfoEditReq;
import com.hro.core.vehiclesys.response.CommonWrapper;
import com.hro.core.vehiclesys.response.PageSearchWrapper;
import com.hro.core.vehiclesys.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoDao carInfoDao;

    @Override
    public CommonWrapper addInfo(CarInfoEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        String carNo = req.getCarNo();
        boolean isExist = this.isExists(carNo);
        if(isExist) {
            wrapper.setResultMsg("该车辆信息已存在");
            return wrapper;
        }
        Date date = new Date();
        CarInfo info = new CarInfo();
        info.setCarName(req.getCarName());
        info.setCarNo(req.getCarNo());
        info.setCarColor(req.getCarColor());
        info.setOwnerId(req.getOwnerId());
        info.setCreationTime(date);

        int cnt = carInfoDao.add(info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    @Override
    public CommonWrapper updateInfo(CarInfoEditReq req) {
        CommonWrapper wrapper = new CommonWrapper();
        wrapper.setResultCode(ResultCodeEnum.FAILURE.getCode());

        Date date = new Date();
        CarInfo info = new CarInfo();
        info.setCarName(req.getCarName());
        info.setCarNo(req.getCarNo());
        info.setCarColor(req.getCarColor());
        info.setOwnerId(req.getOwnerId());
        info.setUpdateTime(date);

        int cnt = carInfoDao.update(req.getRecordId(), info);
        if(cnt > 0) {
            wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
            wrapper.setResultMsg(ResultCodeEnum.SUCCESS.getDesc());
        }
        return wrapper;
    }

    @Override
    public PageSearchWrapper queryPage(int pageNo, int pageSize, String beginTime, String endTime, String carNo) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        int total = carInfoDao.queryPageTotal(beginTime, endTime, carNo);
        List<CarInfo> result = carInfoDao.queryPage(pageNo, pageSize, beginTime, endTime, carNo);

        wrapper.setTotalCount(total);
        wrapper.setPageNo(pageNo);
        wrapper.setRecords(result);
        wrapper.setResultCode(ResultCodeEnum.SUCCESS.getCode());
        
        return wrapper;
    }

    private boolean isExists(String carNo) {
        boolean isExist= false;
        CarInfo condition = new CarInfo();
        condition.setCarNo(carNo);

        List<CarInfo> dataList = carInfoDao.query(condition);
        if(!CollectionUtils.isEmpty(dataList)) {
            isExist = true;
        }
        return isExist;
    }
}
