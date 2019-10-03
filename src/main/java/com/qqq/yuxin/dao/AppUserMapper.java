package com.qqq.yuxin.dao;

import com.qqq.yuxin.model.AppUser;

public interface AppUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);
}