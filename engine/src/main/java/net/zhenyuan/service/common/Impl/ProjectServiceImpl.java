package net.zhenyuan.service.common.Impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.zhenyuan.dto.common.ProjectDTO;
import net.zhenyuan.mapper.ProjectMapper;
import net.zhenyuan.model.ProjectDO;
import net.zhenyuan.req.common.ProjectAddReq;
import net.zhenyuan.req.common.ProjectUpdateReq;
import net.zhenyuan.service.common.ProjectService;
import net.zhenyuan.utils.SpringBeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<ProjectDTO> list() {

        List<ProjectDO> projectDOS = projectMapper.selectList(null);

        List<ProjectDTO> projectDTOS = SpringBeanUtil.copyProperties(projectDOS, ProjectDTO.class);

        return projectDTOS;
    }

    @Override
    public int add(ProjectAddReq projectAddReq) {

        ProjectDO projectDO = SpringBeanUtil.copyProperties(projectAddReq, ProjectDO.class);

        return projectMapper.insert(projectDO);
    }

    @Override
    public int update(ProjectUpdateReq projectUpdateReq) {

        ProjectDO projectDO = SpringBeanUtil.copyProperties(projectUpdateReq, ProjectDO.class);

        return projectMapper.updateById(projectDO);
    }

    @Override
    public int delete(long id) {

        return projectMapper.deleteById(id);
    }


}
