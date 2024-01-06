package net.zhenyuan.controller.common;

import jakarta.annotation.Resource;
import net.zhenyuan.req.common.ProjectSaveReq;
import net.zhenyuan.req.common.ProjectDelReq;
import net.zhenyuan.req.common.ProjectUpdateReq;
import net.zhenyuan.service.common.ProjectService;
import net.zhenyuan.utils.JsonData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @GetMapping ("/list")
    public JsonData list() {
        return JsonData.buildSuccess(projectService.list());
    }

    @PostMapping("/save")
    public JsonData save(@RequestBody ProjectSaveReq req) {
        return JsonData.buildSuccess(projectService.save(req));
    }

    @PostMapping("/update")
    public JsonData update(@RequestBody ProjectUpdateReq req) {
        return JsonData.buildSuccess(projectService.update(req));
    }

    @PostMapping("/del")
    public JsonData delete(@RequestBody ProjectDelReq req) {
        return JsonData.buildSuccess(projectService.delete(req.getId()));
    }


}
