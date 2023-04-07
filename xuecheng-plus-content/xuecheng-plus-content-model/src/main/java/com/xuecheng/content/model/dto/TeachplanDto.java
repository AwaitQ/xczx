package com.xuecheng.content.model.dto;

import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import lombok.Data;

import java.util.List;

/**
 * @description 课程计划信息模型类
 * @author Mr.M
 * @date 2022/9/7 17:40
 * @version 1.0
 */
@Data
public class TeachplanDto extends Teachplan {
    //与媒资关联的信息
    private TeachplanMedia teachplanMedia;

    //小章节List
    private List<TeachplanDto> teachPlanTreeNodes;
}
