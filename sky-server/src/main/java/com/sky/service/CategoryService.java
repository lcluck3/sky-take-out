package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;

public interface CategoryService {

     /**
      * 分类分页查询
      * @param categoryPageQueryDTO
      * @return
      */
     PageResult categoryPageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

     /**
      * 新增分类接口
      * @param categoryDTO
      */
     void add(CategoryDTO categoryDTO);
}
