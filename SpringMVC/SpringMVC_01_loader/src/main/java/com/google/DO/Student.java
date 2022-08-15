package com.google.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: lenny
 * @Date: 2022/8/9 23:05
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 89749674396L;

    private Integer id;
    private String name;
    private Integer age;
}
