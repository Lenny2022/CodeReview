package com.lenny.table01;

import com.lenny.bean.Card;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/15 20:24
 * @Description:
 */
public interface OneToOneMapper {
    /**
     * 查询所有
     * @return List<Card>
     */
    public  List<Card> selectAll();
}
