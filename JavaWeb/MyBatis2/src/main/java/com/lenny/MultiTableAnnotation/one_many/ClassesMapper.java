package com.lenny.MultiTableAnnotation.one_many;

import com.lenny.bean.Classes;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/16 22:18
 * @Description: 注解开发: 一对多
 * <p>
 * SELECT c.id cid, c.name cname, s.id sid, s.name sname, s.age sage
 * FROM classes c,
 * student s
 * WHERE c.id = s.cid
 */
public interface ClassesMapper {
    @Select("select * from classes")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(property = "students",
                    column = "id",  //classes表的外键 id作为条件，关联student表的id
                    javaType = List.class,

                    many = @Many(select = "com.lenny.MultiTableAnnotation.one_many.StudentMapper.selectByCid")
            )

    })
    public List<Classes> selectAll();

}
