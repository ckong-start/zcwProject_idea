package com.atcrowdfunding.service;

import com.atcrowdfunding.bean.TMenu;

import java.util.List;

/**
 * @create 2020-02-04 16:55
 */
public interface TMenuServiece {
    //获取所有菜单
    List<TMenu> getAllMenus();
    //获取菜单
    List<TMenu> getMenus();
}
