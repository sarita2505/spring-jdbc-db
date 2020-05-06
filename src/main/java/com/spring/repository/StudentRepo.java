package com.spring.repository;

import com.spring.model.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentRepo {
    //void setDataSource(DataSource source);
    int insertRow(Student student);
    int updateRow(Integer id,Integer age);
    int delete(Integer id);
    List<Student> selectAll();
    Student selectById(Integer id);
}
