package com.wangwangmumu.weblog.admin.service.impl;

import com.wangwangmumu.weblog.admin.model.vo.user.FindUserInfoRspVO;
import com.wangwangmumu.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.wangwangmumu.weblog.admin.service.AdminUserService;
import com.wangwangmumu.weblog.common.domain.mapper.UserMapper;
import com.wangwangmumu.weblog.common.enums.ResponseCodeEnum;
import com.wangwangmumu.weblog.common.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: 犬小哈
 * @url: www.wangwangmumu.com
 * @date: 2023-09-15 14:03
 * @description: TODO
 **/
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    @Override
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        // 拿到用户名、密码
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();

        // 加密密码
        String encodePassword = passwordEncoder.encode(password);

        // 更新到数据库
        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    /**
     * 获取当前登录用户信息
     * @return
     */
    @Override
    public Response findUserInfo() {
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();

        return Response.success(FindUserInfoRspVO.builder().username(username).build());
    }
}
