package com.atcrowdfunding.service.impl;

import com.atcrowdfunding.bean.TAdmin;
import com.atcrowdfunding.bean.TAdminExample;
import com.atcrowdfunding.mapper.TAdminMapper;
import com.atcrowdfunding.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @create 2020-02-04 15:06
 */
@Service
public class TAdminServiceImpl implements TAdminService {
    @Autowired
    TAdminMapper adminMapper;
    @Override
    public TAdmin getAdmin(TAdmin admin) {

        TAdminExample example = new TAdminExample();
        example.createCriteria().andUsernameEqualTo(admin.getLoginacct()).andUserpswdEqualTo(admin.getUserpswd());
        List<TAdmin> admins = adminMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(admins) || admins.size() > 1){
            return null;
        }else {
            return admins.get(0);
        }
    }

    @Override
    public List<TAdmin> getAllAdmin() {
        return adminMapper.selectByExample(null);
    }
}
