package com.cy.youdi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Youdi {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String pl;
    private String pg;
    private String ug;
    private String g;
    private String d;
    private String w;
}
