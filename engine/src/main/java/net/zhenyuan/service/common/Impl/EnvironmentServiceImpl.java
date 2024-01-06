package net.zhenyuan.service.common.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import net.zhenyuan.dto.common.EnvironmentDTO;
import net.zhenyuan.mapper.EnvironmentMapper;
import net.zhenyuan.mapper.ProjectMapper;
import net.zhenyuan.model.EnvironmentDO;
import net.zhenyuan.model.ProjectDO;
import net.zhenyuan.req.common.EnvironmentSaveReq;
import net.zhenyuan.req.common.EnvironmentUpdateReq;
import net.zhenyuan.service.common.EnvironmentService;
import net.zhenyuan.utils.SpringBeanUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnvironmentServiceImpl implements EnvironmentService {

    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private EnvironmentMapper environmentMapper;

    @Override
    public List<EnvironmentDTO> list(Long projectId) {

        LambdaQueryWrapper<EnvironmentDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EnvironmentDO::getProjectId,projectId);
        List<EnvironmentDO> environmentDOS = environmentMapper.selectList(queryWrapper);
        return SpringBeanUtil.copyProperties(environmentDOS,EnvironmentDTO.class);
    }

    @Override
    public int save(EnvironmentSaveReq req) {
        ProjectDO projectDO = projectMapper.selectById(req.getProjectId());
        if (projectDO !=null){
            EnvironmentDO environmentDO = SpringBeanUtil.copyProperties(req, EnvironmentDO.class);
            return environmentMapper.insert(environmentDO);
        }
        return 0;
    }

    @Override
    public int update(EnvironmentUpdateReq req) {
        ProjectDO projectDO = projectMapper.selectById(req.getProjectId());
        if (projectDO !=null){
            EnvironmentDO environmentDO = SpringBeanUtil.copyProperties(req, EnvironmentDO.class);
            return environmentMapper.updateById(environmentDO);
        }
        return 0;
    }

    @Override
    public int delete(Long projectId, Long id) {
        LambdaQueryWrapper<EnvironmentDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EnvironmentDO::getProjectId,projectId);
        queryWrapper.eq(EnvironmentDO::getId,id);
        return environmentMapper.delete(queryWrapper);
    }
}
