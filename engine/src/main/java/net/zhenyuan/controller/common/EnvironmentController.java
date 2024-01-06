package net.zhenyuan.controller.common;

import jakarta.annotation.Resource;
import net.zhenyuan.req.common.EnvironmentDelReq;
import net.zhenyuan.req.common.EnvironmentSaveReq;
import net.zhenyuan.req.common.EnvironmentUpdateReq;
import net.zhenyuan.service.common.EnvironmentService;
import net.zhenyuan.utils.JsonData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/env")
public class EnvironmentController {

    @Resource
    private EnvironmentService environmentService;


    @GetMapping("/list")
    public JsonData list(@RequestParam("projectId")Long projectId){
        return JsonData.buildSuccess(environmentService.list(projectId));
    }


    @PostMapping("/save")
    public JsonData save(@RequestBody EnvironmentSaveReq req){
        return JsonData.buildSuccess(environmentService.save(req));
    }


    @PostMapping("/update")
    public JsonData update(@RequestBody EnvironmentUpdateReq req){
        return JsonData.buildSuccess(environmentService.update(req));
    }

    @PostMapping("/del")
    public JsonData delete(@RequestBody EnvironmentDelReq req){
        return JsonData.buildSuccess(environmentService.delete(req.getProjectId(),req.getId()));
    }
}
