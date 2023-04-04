package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.M
 * @version 1.0
 * @description 课程分类相关接口
 * @date 2023/3/31 22:44
 */

@RestController
public class CourseCategoryController {

    String ROOT_NODE = "1";

    @Autowired
    CourseCategoryService categoryService;

    @GetMapping("/course-category/tree-nodes")
    public List<CourseCategoryTreeDto> queryTreeNodes() {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = categoryService.queryTreeNodes("1");
        return courseCategoryTreeDtos;
    }
}
