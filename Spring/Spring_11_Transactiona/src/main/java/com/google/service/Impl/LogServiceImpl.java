package com.google.service.Impl;

import com.google.dao.LogDao;
import com.google.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lenny
 * @Date: 2022/8/7 19:40
 * @Description:
 */

@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void log(String out, String in, Double money) {
        log.info(" 转账操作由" + out + "到" + in + ",金额：" + money);
        logDao.generateLog("转账操作由" + out + "到" + in + ",金额：" + money);
    }

}
