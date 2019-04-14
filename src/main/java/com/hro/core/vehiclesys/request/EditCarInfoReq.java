package com.hro.core.vehiclesys.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 编辑车辆信息
 */
@ApiModel(description = "车辆信息消息体")
public class EditCarInfoReq implements Serializable {

    @ApiModelProperty(value = "车辆名称")
    private String carName;

    @ApiModelProperty(value = "车牌号码")
    private String carNo;

    @ApiModelProperty(value = "车主")
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
