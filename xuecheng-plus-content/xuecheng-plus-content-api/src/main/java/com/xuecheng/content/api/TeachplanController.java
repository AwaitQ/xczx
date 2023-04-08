package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.service.TeachplanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mr.M
 * @version 1.0
 * @description 课程计划管理相关接口
 * @date 2023/3/31 22:44
 */

@Api(value = "课程计划编辑接口", tags = "课程计划编辑接口")
@RestController
public class TeachplanController {

    @Autowired
    TeachplanService teachplanService;

    //查询课程计划
    @ApiOperation("查询课程计划树形结构")
    @ApiImplicitParam(value = "courseId", name = "课程id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/teachplan/{courseId}/tree-nodes")
    public List<TeachplanDto> getTreeNodes (@PathVariable Long courseId) {
        List<TeachplanDto> teachplanTree = teachplanService.findTeachplanTree(courseId);
        return teachplanTree;
    }

    //查询课程计划
    @ApiOperation("课程计划创建或修改")
    @PostMapping("/teachplan")
    public void savaTeachplan(@RequestBody SaveTeachplanDto teachplan) {
        teachplanService.saveTeachplan(teachplan);
    }
}
