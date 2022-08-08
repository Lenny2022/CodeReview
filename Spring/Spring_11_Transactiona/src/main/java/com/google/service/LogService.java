package com.google.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: lenny
 * @Date: 2022/8/7 19:38
 * @Description:
 */
public interface LogService {

    /**
     * propagation : 事务的传播行为, 默认值为 REQUIRED,
     * REQUIRED: 如果当前存在事务, 则加入该事务, 否则创建一个新的事务.
     * REQUIRES_NEW: 创建一个新的事务, 如果当前存在事务, 则把当前事务挂起.
     * SUPPORTS: 如果当前存在事务, 则加入该事务, 否则以非事务方式执行.
     * MANDATORY: 如果当前存在事务, 则加入该事务, 否则抛出异常.
     * NEVER: 以非事务方式执行, 无论是否存在事务.
     * NESTED: 如果当前存在事务, 则创建一个事务作为当前事务的嵌套事务来执行.
     *
     * 设置事务的传播行为, 不受当前事务的传播行为影响.
     * @param out
     * @param in
     * @param money
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    void log(String out, String in, Double money);
}
