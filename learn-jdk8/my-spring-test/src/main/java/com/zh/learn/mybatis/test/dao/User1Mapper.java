package com.zh.learn.mybatis.test.dao;

import com.zh.learn.mybatis.test.model.User1;

public interface User1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    int insert(User1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    int insertSelective(User1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    User1 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(User1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user1
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(User1 record);
}