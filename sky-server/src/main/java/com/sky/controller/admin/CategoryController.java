package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/category/")
@Slf4j
@Api(tags = "分类相关接口")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO) {
        log.info("categoryPageQueryDTO:{}", categoryPageQueryDTO);
        PageResult pageResult = categoryService.categoryPageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增分类查询
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增分类接口")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("categoryDTO:{}", categoryDTO);
        categoryService.add(categoryDTO);
        return Result.success();
    }
    /**
     *
     * 上传测试
     */
    /**
     * 更改分类状态
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("修改分类状态")
    public Result changeCategoryStatus(@PathVariable("status") Integer status , Long id){
        log.info("status:{},id:{}", status, id);
        categoryService.change(status,id);
        return Result.success();
    }
}