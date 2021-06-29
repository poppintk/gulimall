package com.atguigu.gulimall.cart.controller;

import com.atguigu.gulimall.cart.interceptor.CartInterceptor;
import com.atguigu.gulimall.cart.vo.UserInfoTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    /**
     * 浏览器有一个Cookie: user-key:标识用户身份，一个月后过期
     * 如果第一次使用购物车功能，都会给一个临时用户身份
     * 浏览器以后保存， 每次反问都会带上
     * @return
     * 登录： session 有
     * 没登录： 按照cookie里面带来user-key来做
     * 第一次： 如果没有临时用户， 帮忙创建一个临时用户
     */
    @GetMapping("/cart.html")
    public String cartListPage() {
        // 快速等到用户信息， id, user-key.用ThreadLocal-同一个线程共享数据
        // (one thread)拦截器 -> controller -> service -> dao

        UserInfoTo userInfoTo = CartInterceptor.threadLocal.get();

        return "cartList";
    }
}
