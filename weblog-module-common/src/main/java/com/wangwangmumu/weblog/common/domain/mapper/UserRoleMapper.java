package com.wangwangmumu.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangwangmumu.weblog.common.domain.dos.CategoryDO;
import com.wangwangmumu.weblog.common.domain.dos.UserRoleDO;

import java.util.List;

/**
 * @author: 犬小哈
 * @url: www.wangwangmumu.com
 * @date: 2023-08-22 17:06
 * @description: TODO
 **/
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

    default List<UserRoleDO> selectByUsername(String username) {
        LambdaQueryWrapper<UserRoleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRoleDO::getUsername, username);

        return selectList(wrapper);
    }
}
