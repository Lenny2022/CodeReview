package com.google.dao;

import com.google.DO.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/29 07:53
 * @Description:
 */


public interface AccountDao {

    /**
     * 收款接口
     * @param money
     * @param name
     */
    @Update("update tbl_account set money = money + #{money} where name = #{name} ")
    void inMoney(@Param("money") Double money, @Param("name") String name);


    /**
     * 付款接口
     * @param money
     * @param name
     */
    @Update("update tbl_account set money = money - #{money} where name = #{name} ")
    void outMoney(@Param("money") Double money, @Param("name") String name);
}

