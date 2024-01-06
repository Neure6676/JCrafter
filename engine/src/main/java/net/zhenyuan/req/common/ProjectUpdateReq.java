package net.zhenyuan.req.common;

import lombok.Data;

@Data
public class ProjectUpdateReq {

    public long id;

    private String name;

    private String description;
}
