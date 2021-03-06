package com.hro.core.vehiclesys.dao;

import com.hro.core.vehiclesys.dao.mapper.CarInfoMapper;
import com.hro.core.vehiclesys.dao.model.CarInfo;
import com.hro.core.vehiclesys.dao.model.CarInfoExample;
import com.hro.core.vehiclesys.utils.DateUtils;
import com.hro.core.vehiclesys.utils.RowBoundsUtil;
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
     * @param ids
     * @return
     */
    public int delete(List<Integer> ids) {
        int cnt = carInfoMapper.batchDelete(ids);
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
        if(condition.getOwnerId() != null && condition.getOwnerId() != 0 ) {
            criteria.andOwnerIdEqualTo(condition.getOwnerId());
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
        int offset = (pageNo-1)*pageSize;
        CarInfoExample example = new CarInfoExample();
        CarInfoExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(carNo)) {
            criteria.andCarNoLike("%" + carNo + "%");
        }
        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }

        List<CarInfo> result = carInfoMapper.selectByExampleWithRowbounds(example, RowBoundsUtil.of(offset, pageSize));
        return result;
    }

    /**
     * 获取分页查询的记录总数
     * @param beginTime
     * @param endTime
     * @param keywords
     * @return
     */
    public int queryPageTotal(String beginTime, String endTime, String keywords) {
        CarInfoExample example = new CarInfoExample();
        CarInfoExample.Criteria criteria = example.createCriteria();

        if(!StringUtils.isEmpty(beginTime)) {
            criteria.andCreationTimeGreaterThanOrEqualTo(DateUtils.parseStrToDate(beginTime,"yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(endTime)) {
            criteria.andCreationTimeLessThanOrEqualTo(DateUtils.parseStrToDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        }
        if(!StringUtils.isEmpty(keywords)) {
            criteria.andCarNoLike("%" + keywords + "%");
        }

        int total = carInfoMapper.countByExample(example);
        return total;
    }
}
