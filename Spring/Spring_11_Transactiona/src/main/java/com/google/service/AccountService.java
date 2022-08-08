package com.google.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author lenny
 */
public interface AccountService {

    /**
     * 转账接口
     * Transactional: 开启事务, rollbackFor: 异常回滚, noRollbackFor: 不回滚的异常
     * 注解可以加载接口的方法上,也可以加载类上, 如果加载类上,则类上的方法都会加载上
     * @param outName 转出账户名
     * @param inName 转入账户名
     * @param money 转账金额
     */

    @Transactional(rollbackFor = Exception.class)
    void transfer(String outName, String inName, Double money);
}
