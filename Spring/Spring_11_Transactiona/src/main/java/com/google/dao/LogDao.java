package com.google.dao;

import org.apache.ibatis.annotations.Insert;

/**
 * @author: lenny
 * @Date: 2022/8/7 19:29
 * @Description:
 */
public interface LogDao {

    /**
     * 操作记录
     *
     * @param info 日志信息
     */
    @Insert("insert into real_pst_log_tbl(info,createDate) values(#{info},now(3))")
    void generateLog(String info);

}
