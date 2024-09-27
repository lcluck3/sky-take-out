package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.mapper.CategoryMapper;
import com.sky.result.PageResult;
import com.sky.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    public PageResult categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPage(),categoryPageQueryDTO.getPageSize());
        Page<Category> page =categoryMapper.page(categoryPageQueryDTO);
        Long total = page.getTotal();
        List<Category> list = page.getResult();
        return new PageResult(total,list);
    }

    /**
     * 新增分类接口
     * @param categoryDTO
     */
    @Override
    public void add(CategoryDTO categoryDTO) {
       Category category = new Category();
       //复制给实体
       BeanUtils.copyProperties(categoryDTO,category);
       //设置初始值
       category.setCreateTime(LocalDateTime.now());
       category.setUpdateTime(LocalDateTime.now());
       category.setCreateUser(BaseContext.getCurrentId());
       category.setUpdateUser(BaseContext.getCurrentId());
       category.setStatus(StatusConstant.ENABLE);
       //传入后端
       categoryMapper.add(category);
    }
}
