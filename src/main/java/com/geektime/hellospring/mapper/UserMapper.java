package com.geektime.hellospring.mapper;

import com.geektime.hellospring.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO user(NAME, AGE) VALUES(#{name, jdbcType=VARCHAR}, #{age, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    @Update("UPDATE user SET AGE=#{age} WHERE NAME=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE ID=#{id}")
    void delete(Integer id);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();
}
