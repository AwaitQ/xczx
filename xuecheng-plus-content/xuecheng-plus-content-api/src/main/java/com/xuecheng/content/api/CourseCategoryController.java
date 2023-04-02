package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.M
 * @version 1.0
 * @description 课程分类相关接口
 * @date 2023/3/31 22:44
 */

@RestController
public class CourseCategoryController {
    @GetMapping("/course-cateory/tree-nodes")
    public CourseCategoryTreeDto queryTreeNodes() {
        return null;
    }
}
