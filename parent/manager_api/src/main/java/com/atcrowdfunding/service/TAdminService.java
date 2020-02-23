package com.atcrowdfunding.service;

import com.atcrowdfunding.bean.TAdmin;

import java.util.List;

/**
 * @create 2020-02-04 15:03
 */
public interface TAdminService {
    //查询管理员
    TAdmin getAdmin(TAdmin admin);
    //获取所有的管理员
    List<TAdmin> getAllAdmin();
}
