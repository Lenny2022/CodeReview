package com.google.dao.Impl;

import com.google.dao.FishDao;
import org.springframework.stereotype.Component;

/**
 * @author: lenny
 * @Date: 2022/8/2 06:52
 * @Description:
 */

@Component
public class FishDaoImpl implements FishDao {
    @Override
    public void price() {
        System.out.println("How much is this fish?");
    }

    @Override
    public void num() {
        //System.out.println(System.currentTimeMillis());
        System.out.println("num");
    }
}
