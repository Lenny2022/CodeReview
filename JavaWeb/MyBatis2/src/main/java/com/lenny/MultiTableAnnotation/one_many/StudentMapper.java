package com.lenny.MultiTableAnnotation.one_many;

import com.lenny.bean.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 22:17
 * @Description:
 */
public interface StudentMapper {
    /**
     * 根据cid查询student表
     * @param cid
     * @return
     */
    @Select("SELECT * FROM student WHERE cid=#{cid}")
    public abstract List<Student> selectByCid(Integer cid);
}
