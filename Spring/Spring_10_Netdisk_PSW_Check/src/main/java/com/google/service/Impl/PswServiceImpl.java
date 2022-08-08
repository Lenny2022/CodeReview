package com.google.service.Impl;

import com.google.dao.PswDao;
import com.google.service.PswService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/3 20:59
 * @Description:
 */

@Component
public class PswServiceImpl implements PswService {

    @Autowired
    private PswDao pswDao;

    @Override
    public boolean openUrl(String password) {
        return pswDao.checkPsw(password);
    }
}
