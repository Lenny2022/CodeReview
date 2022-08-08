package com.google.service.Impl;

import com.google.DO.Account;
import com.google.dao.AccountDao;
import com.google.service.AccountService;
import com.google.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lenny
 */

@Service
@Slf4j
// 这里@Service注解的意思是，将这个类的对象注入到spring容器中，这样spring容器就可以自动获取到这个类的对象了。
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    public void transfer2(String outName, String inName, Double money) {
        log.info("转账开始,outMoney");
        accountDao.outMoney(money, outName);

        // 模拟异常,此时转账失败, 转账但没收到钱,
        // 这个场景,要么同时成功要么同时失败, 这就是"事物"的特性;
        //int a = 1 / 0;
        log.info("转账,inMoney");
        accountDao.inMoney(money, inName);
        log.info("转账结束");
    }

    /**
     * 开启事物,再次测试场景
     *
     * @param outName 转出账户名
     * @param inName  转入账户名
     * @param money   转账金额
     */
    @Override
    public void transfer(String outName, String inName, Double money) {
        try {
            accountDao.outMoney(money, outName);
            // 模拟异常,此时转账失败, 转账但没收到钱,
            // 这个场景,要么同时成功要么同时失败, 这就是"事物"的特性;
            //int a = 1 / 0;
            accountDao.inMoney(money, inName);
        } finally {
            logService.log(outName, inName, money);
        }
    }
}
