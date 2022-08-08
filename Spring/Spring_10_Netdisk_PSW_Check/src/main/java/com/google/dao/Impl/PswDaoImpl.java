package com.google.dao.Impl;

import com.google.dao.PswDao;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/3 21:05
 * @Description:
 */

@Component
public class PswDaoImpl implements PswDao {

    @Override
    public boolean checkPsw(String password) {
        return "1234".equals(password);
    }
}
