package com.atguigu.gulimall.product.web;


import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.gulimall.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;


    @GetMapping({"/", "/index.html"})
    public String IndexPage(Model model) {

        // TODO 查出所有一级分类
        List<CategoryEntity> level1Categorys = categoryService.getLevel1Categorys();
        model.addAttribute("categories", level1Categorys);
        return "index";
    }

    //index/catalog.json
    @GetMapping("index/catalog.json")
    @ResponseBody
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }
}
