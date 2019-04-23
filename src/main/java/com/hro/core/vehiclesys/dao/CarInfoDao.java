package com.hro.core.vehiclesys.dao;

import com.hro.core.vehiclesys.dao.mapper.CarInfoMapper;
import com.hro.core.vehiclesys.dao.model.CarInfo;
import com.hro.core.vehiclesys.dao.model.CarInfoExample;
import com.hro.core.vehiclesys.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 车辆信息DAO
 */
@Repository
public class CarInfoDao {

    @Autowired
    private CarInfoMapper carInfoMapper;

    /**
     * 添加车辆信息
     * @param carInfo
     * @return
     */
    public int add(CarInfo carInfo) {
        return carInfoMapper.insert(carInfo);
    }

    /**
     * 修改车辆信息
     * @param id
     * @param carInfo
     * @return
     */
    public int update(int id, CarInfo carInfo) {
        CarInfoExample example = new CarInfoExample();
        example.createCriteria().andIdEqualTo(id);

        return carInfoMapper.updateByExampleSelective(carInfo, example);
    }

    /**
     * 删除车辆信息
     * @param id
     * @return
     */
    public int delete(int id) {
        int cnt = 0;
        CarInfoExample example = new CarInfoExample();
        example.createCriteria().andIdEqualTo(id);

        cnt = carInfoMapper.deleteByExample(example);
        return cnt;
    }

    /**
     * 条件查询车辆信息
     * @param condition
     * @return
     */
    public List<CarInfo> query(CarInfo condition) {
        List<CarInfo> result = null;
        CarInfoExample example = new CarInfoExample();
        CarInfoExample.Criteria criteria = example.createCriteria();

        String carColor = condition.getCarColor();
        if(!StringUtils.isEmpty(carColor)) {
            criteria.andCarColorEqualTo(carColor);
        }
        String carNo = condition.getCarNo();
        if(!StringUtils.isEmpty(carNo)) {
            criteria.andCarNoEqualTo(carNo);
        }
        int ownerId = condition.getOwnerId();
        if(ownerId != 0 ) {
            criteria.andOwnerIdEqualTo(ownerId);
        }
        result = carInfoMapper.selectByExample(example);
        return result;
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param beginTime
     * @param endTime
     * @param carNo
     * @return
     */
    public List<CarInfo> queryPage(int pageNo, int pageSize, String beginTime, String endTime, String carNo) {
        return null;
    }
}
