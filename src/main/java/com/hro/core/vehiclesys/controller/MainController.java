package com.hro.core.vehiclesys.controller;

import com.hro.core.vehiclesys.request.CarInfoEditReq;
import com.hro.core.vehiclesys.response.CommonWrapper;
import com.hro.core.vehiclesys.response.PageSearchWrapper;
import com.hro.core.vehiclesys.service.CarInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "main", description = "车辆相关API")
@RestController
@RequestMapping(value = "main")
public class MainController {

    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private CarInfoService carInfoService;

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
        PageSearchWrapper wrapper = carInfoService.queryPage(pageNo, pageSize, startTime, endTime, keywords);

        logger.debug(" startTime = {}, endTime = {}, pageNo = {}, pageSize = {}, keywords = {}",
                new Object[]{startTime, endTime, pageNo, pageSize, keywords});

//        List<VehicleModel> records = new ArrayList<>();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for(int i = 0; i< 50; i++) {
//            VehicleModel model = new VehicleModel();
//            model.setAddress("addr_"+ i);
//            model.setDate(dateFormat.format(new Date()));
//            model.setName("test_"+ i);
//
//            records.add(model);
//        }
//
//        wrapper.setPageNo(pageNo);
//        wrapper.setRecords(records);
//        wrapper.setTotalCount(101);
//        wrapper.setResultCode(100);
//        wrapper.setResultMsg("SUCCESS");

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
    public CommonWrapper add(@RequestBody CarInfoEditReq params) {
        CommonWrapper wrapper = new CommonWrapper();

        logger.debug(" params = {}",
                new Object[]{params});

        wrapper.setResultCode(100);
        wrapper.setResultMsg("SUCCESS");

        return wrapper;
    }
}
