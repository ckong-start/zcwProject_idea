package com.atcrowdfunding.test;

import com.atcrowdfunding.bean.TAdmin;
import com.atcrowdfunding.bean.TMenu;
import com.atcrowdfunding.mapper.TAdminMapper;
import com.atcrowdfunding.mapper.TMenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @create 2020-02-03 13:32
 */
@ContextConfiguration(locations = {"classpath:spring/spring-beans.xml", "classpath:spring/spring-tx.xml", "classpath:spring/spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SsmTest {
    @Autowired
    TAdminMapper adminMapper;
    @Autowired
    TMenuMapper menuMapper;
    @Test
    public void test(){
        long startTime = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(getClass());
        TAdmin admin = adminMapper.selectByPrimaryKey(1);
        logger.info("查询所花费的时间是：{}", System.currentTimeMillis() - startTime);
        logger.debug("查询的admin：{}", admin);
    }

    @Test
    public void getMenu(){
        List<TMenu> menuList = menuMapper.selectByExample(null);
        for (TMenu menu: menuList) {
            System.out.println(menu);
        }
    }
    @Test
    public void getMenus(){
        List<TMenu> menuList = menuMapper.selectByExample(null);
        Map<Integer, TMenu> pMenus = new HashMap<>();

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
        Set<Integer> ids = pMenus.keySet();
        for (Integer id : ids) {
            System.out.println(id + ":" + pMenus.get(id));
        }
    }
}
