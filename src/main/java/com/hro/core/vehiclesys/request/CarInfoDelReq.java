package com.hro.core.vehiclesys.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 删除车辆信息
 */
@ApiModel(description = "删除车辆信息消息体")
public class CarInfoDelReq implements Serializable {

    @ApiModelProperty(value = "记录ID")
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "CarInfoDelReq{" +
                "ids=" + ids +
                '}';
    }
}
