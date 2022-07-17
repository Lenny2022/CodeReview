package com.google.GenerateSql;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;


/**
 * @author: lenny
 * @Date: 2022/7/17 15:23
 * @Description: MyBatis自动生成sql
 */
public class Demo {

    @Test
    public void generateSql() {
        String sql = getSql();
        System.out.println(sql);
    }

    private String getSql() {

        return new SQL() {
            {
                SELECT("*");
                FROM("student");
            }
        }.toString();
    }
}
