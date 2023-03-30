package com.xuecheng.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author Mr.Lv
 * @version 1.0
 * @description 分页查询分页参数
 * @date 2023/3/30 21:52
 */
@Data
@ToString
public class PageParams {
    //当前页码
    @ApiModelProperty(value = "页码")
    private Long pageNo = 1L;
    //每页记录数
    @ApiModelProperty(value = "每页记录数")
    private Long pageSize = 30L;

    public PageParams(Long pageNo, Long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public PageParams() {
    }
}
