package com.spring.repository;

import com.spring.mappper.StudentMapper;
import com.spring.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class StudentRepoImpl implements StudentRepo {
    String insert = "INSERT INTO STUDENT(NAME,AGE) VALUES(?,?)";
    String update = "UPDATE STUDENT SET AGE=? WHERE ID=?";
    String select = "SELECT * FROM STUDENT";
    String selectById = "SELECT * FROM STUDENT WHERE ID=? ";
    String delete = "DELETE FROM STUDENT WHERE ID=?";

    //private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public StudentRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    @Override
//    public void setDataSource(DataSource source) {
//        this.dataSource = source;
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Override
    public int insertRow(Student student) {
        int i = 0;
        i = jdbcTemplate.update(insert, new Object[]{student.getName(), student.getAge()});
        return i;
    }

    @Override
    public int updateRow(Integer id, Integer age) {
        int i = 0;
        i = jdbcTemplate.update(update, new Object[]{id, age});
        return i;
    }

    @Override
    public int delete(Integer id) {
        int i = 0;
        i = jdbcTemplate.update(delete, new Object[]{id});
        return i;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        students = jdbcTemplate.query(select, new StudentMapper());
        return students;
    }

    @Override
    public Student selectById(Integer id) {
        Student student = new Student();
        student = jdbcTemplate.queryForObject(selectById, new StudentMapper());
        return student;
    }
}
