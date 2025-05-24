package com.wangwangmumu.weblog.admin.service;

import com.wangwangmumu.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.wangwangmumu.weblog.common.utils.Response;

/**
 * @author: 犬小哈
 * @url: www.wangwangmumu.com
 * @date: 2023-09-15 14:03
 * @description: TODO
 **/
public interface AdminUserService {
    /**
     * 修改密码
     * @param updateAdminUserPasswordReqVO
     * @return
     */
    Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Response findUserInfo();
}
