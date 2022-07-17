package com.lenny.MultiTableAnnotation.one_one;

import com.lenny.bean.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 21:22
 * @Description: MyBatis注解操作一对一关系
 */
public interface PersonMapper {

    /**
     * 根据id查询人
     * Card: id,number,pid:
     * Person: id,NAME,age;
     * xml查询语句:
     * SELECT c.id cid, number, pid, NAME, age
     * FROM card c,
     * person p
     * WHERE c.pid = p.id
     *
     * @param id
     * @return
     */
    @Select("select * from person where id = #{id}")
    public List<Person> selectById(Integer id);
}
