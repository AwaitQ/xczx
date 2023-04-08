package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/14 12:11
 */
@Service
public class TeachplanServiceImpl implements TeachplanService {

    @Autowired
    TeachplanMapper teachplanMapper;

    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos;
    }

    @Override
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        //通过课程计划id判断是新增还是修改
        Long id = saveTeachplanDto.getId();
        if(id == null ){
            //新增
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            //确定排序字段，找到它的同级节点个数，排序字段就是个数加1
            Long parentId = saveTeachplanDto.getParentid();
            Long courseId = saveTeachplanDto.getCourseId();

            int teachplanCount = getTeachplanCount(parentId, courseId);
            teachplan.setOrderby(teachplanCount);

            teachplanMapper.insert(teachplan);
        } else {
            //修改
            Teachplan teachplan = teachplanMapper.selectById(id);
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            teachplanMapper.updateById(teachplan);
        }
    }

    private int getTeachplanCount(long parentId, long courId) {
        LambdaQueryWrapper<Teachplan> queryWraper = new LambdaQueryWrapper<>();
        queryWraper = queryWraper.eq(Teachplan::getParentid, parentId).eq(Teachplan::getCourseId, courId);
        Integer count = teachplanMapper.selectCount(queryWraper);
        return count + 1;
    }

}
