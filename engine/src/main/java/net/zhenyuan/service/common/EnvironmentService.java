package net.zhenyuan.service.common;



import net.zhenyuan.dto.common.EnvironmentDTO;
import net.zhenyuan.req.common.EnvironmentSaveReq;
import net.zhenyuan.req.common.EnvironmentUpdateReq;

import java.util.List;

public interface EnvironmentService {

    List<EnvironmentDTO> list(Long projectId);

    int save(EnvironmentSaveReq req);

    int update(EnvironmentUpdateReq req);

    int delete(Long projectId, Long id);
}
