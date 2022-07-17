package com.lenny.table02;

import com.lenny.bean.Classes;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/15 20:24
 * @Description:
 */
public interface OneToManyMapper {
    /**
     * 查询所有
     * @return List<Card>
     */
    public  List<Classes> selectAll();
}
