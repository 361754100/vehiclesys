package com.hro.core.vehiclesys.request;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 编辑车辆信息
 */
@ApiModel
public class EditCarInfoReq implements Serializable {

    private String carName;

    private String carNo;

    private String owner;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "EditCarInfoReq{" +
                "carName='" + carName + '\'' +
                ", carNo='" + carNo + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
