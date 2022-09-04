package org.example.archetype.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.example.archetype.entity.UserTest;
import org.example.archetype.entity.UserTestCriteria;

public interface UserTestDao {
    long countByCriteria(UserTestCriteria example);

    int deleteByCriteria(UserTestCriteria example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserTest row);

    int insertSelective(UserTest row);

    List<UserTest> selectByCriteria(UserTestCriteria example);

    UserTest selectByPrimaryKey(Long userId);

    int updateByCriteriaSelective(@Param("row") UserTest row, @Param("example") UserTestCriteria example);

    int updateByCriteria(@Param("row") UserTest row, @Param("example") UserTestCriteria example);

    int updateByPrimaryKeySelective(UserTest row);

    int updateByPrimaryKey(UserTest row);
}