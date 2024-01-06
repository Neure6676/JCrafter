package net.zhenyuan.service.common;
import net.zhenyuan.dto.common.ProjectDTO;
import net.zhenyuan.req.common.ProjectAddReq;
import net.zhenyuan.req.common.ProjectDelReq;
import net.zhenyuan.req.common.ProjectUpdateReq;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> list();

    int add(ProjectAddReq projectAddReq);

    int update(ProjectUpdateReq projectAddReq);

    int delete(long id);
}
