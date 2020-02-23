package com.atcrowdfunding.service.impl;

import com.atcrowdfunding.bean.TMenu;
import com.atcrowdfunding.mapper.TMenuMapper;
import com.atcrowdfunding.service.TMenuServiece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2020-02-04 16:57
 */
@Service
public class TMenuServiceImpl implements TMenuServiece {
    @Autowired
    TMenuMapper menuMapper;
    @Override
    public List<TMenu> getAllMenus() {
        return menuMapper.selectByExample(null);
    }

    @Override
    public List<TMenu> getMenus() {
        List<TMenu> menuList = getAllMenus();
        Map<Integer, TMenu> pMenus = new HashMap<>();
        //将pid=0的父菜单找出来，并添加到map中
        for (TMenu tMenu : menuList) {
            if (tMenu.getPid() == 0){
                pMenus.put(tMenu.getId(), tMenu);
            }
        }
        //给父菜单的元素添加子菜单
        for (TMenu tMenu : menuList) {
            if (tMenu.getPid() != 0){
                pMenus.get(tMenu.getPid()).getChildren().add(tMenu);
            }
        }
        return  new ArrayList<>(pMenus.values());
    }
}
