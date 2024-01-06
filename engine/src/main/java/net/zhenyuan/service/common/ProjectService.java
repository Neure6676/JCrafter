package net.zhenyuan.service.common;
import net.zhenyuan.dto.common.ProjectDTO;
import net.zhenyuan.req.common.ProjectSaveReq;
import net.zhenyuan.req.common.ProjectUpdateReq;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO> list();

    int save(ProjectSaveReq projectSaveReq);

    int update(ProjectUpdateReq projectAddReq);

    int delete(long id);
}
