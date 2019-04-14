package com.hro.core.vehiclesys.controller;

import com.hro.core.vehiclesys.dao.model.VehicleModel;
import com.hro.core.vehiclesys.request.EditCarInfoReq;
import com.hro.core.vehiclesys.response.CommonWrapper;
import com.hro.core.vehiclesys.response.PageSearchWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Api(tags = "main", description = "车辆相关API")
@RestController
@RequestMapping(value = "main")
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @ApiOperation(value = "分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="startTime", value = "开始时间", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="endTime", value = "结束时间", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
            @ApiImplicitParam(name="keywords", value = "关键字", required = true, paramType = "form", dataType = "String")
    })
    @PostMapping(value = "/vehicle/page_search")
    public PageSearchWrapper pageSearch(@RequestParam String startTime, @RequestParam String endTime,
                                        @RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String keywords) {
        PageSearchWrapper wrapper = new PageSearchWrapper();

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});

        VehicleModel model1 = new VehicleModel();
        model1.setAddress("111");
        model1.setDate("2019-03-18");
        model1.setName("test1");

        VehicleModel model2 = new VehicleModel();
        model2.setAddress("222");
        model2.setDate("2019-03-18");
        model2.setName("test2");

        List<VehicleModel> records = new ArrayList<>();
        records.add(model1);
        records.add(model2);

        wrapper.setPageNo(1);
        wrapper.setRecords(records);
        wrapper.setTotalCount(2);
        wrapper.setResultCode(100);
        wrapper.setResultMsg("SUCCESS");

        return wrapper;
    }

    @ApiOperation(value = "新增车辆信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="car", value = "开始时间", required = true, paramType = "form", dataType = "String"),
//            @ApiImplicitParam(name="endTime", value = "结束时间", required = true, paramType = "form", dataType = "String"),
//            @ApiImplicitParam(name="pageNo", value = "当前页", required = true, paramType = "form", dataType = "int"),
//            @ApiImplicitParam(name="pageSize", value = "每页大小", required = true, paramType = "form", dataType = "int"),
//            @ApiImplicitParam(name="keywords", value = "关键字", required = true, paramType = "form", dataType = "String")
//    })
    @PostMapping(value = "/vehicle/add")
    public CommonWrapper add(@RequestBody EditCarInfoReq params) {
        CommonWrapper wrapper = new CommonWrapper();

        logger.debug(" params = {}",
                new Object[]{params});

        wrapper.setResultCode(100);
        wrapper.setResultMsg("SUCCESS");

        return wrapper;
    }
}
