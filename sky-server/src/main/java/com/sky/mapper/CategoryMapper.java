package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    public  Page<Category> page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 新增员工
     * @param category
     */
    @Insert("insert into category(type,name,sort,status,create1_time,update_time,create_user," +
            "update_user) values (#{type},#{name},#{sort},#{status},#{createTime},#{updateTime}," +
            "#{createUser},#{updateUser})")
    void add(Category category);

    /**
     * 更改分类状态
     * @param category
     */
    void update(Category category);
}
