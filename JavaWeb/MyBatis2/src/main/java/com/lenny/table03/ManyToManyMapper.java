package com.lenny.table03;

import com.lenny.bean.Classes;
import com.lenny.bean.Student;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/15 20:24
 * @Description:
 */
public interface ManyToManyMapper {
    /**
     * 查询所有
     * @return List<Card>
     */
    public List<Student> selectAll();
}
