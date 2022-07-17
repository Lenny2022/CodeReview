package com.lenny.MultiTableAnnotation.one_one;

import com.lenny.bean.Card;
import com.lenny.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 21:34
 * @Description:
 */
public interface CardMapper {

    @Select("select * from card ")
    @Results({
            // @column: 数据库字段名, property: 对应实体类要封装的字段名
            @Result(column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(column = "pid", // card表的外键 pid作为条件，关联person表的id
                    property = "p", // person对象,p
                    javaType = Person.class,    //person类型

                    // 得到peroson的查询结果 select * from person where id = #{id} 返回一个person对象
                    one = @One(select = "com.lenny.MultiTableAnnotation.one_one.PersonMapper.selectById")),
    })

    public List<Card> selectAll();

}
