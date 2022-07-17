package com.lenny.bean;

/**
 * @author: lenny
 * @Date: 2022/7/15 22:59
 * @Description:
 */

public class Course {
    private Integer id;     //主键id
    private String name;    //课程名称

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
