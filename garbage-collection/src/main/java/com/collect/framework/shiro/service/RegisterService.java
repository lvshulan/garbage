package com.collect.framework.shiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.collect.common.constant.Constants;
import com.collect.common.constant.ShiroConstants;
import com.collect.common.constant.UserConstants;
import com.collect.common.utils.MessageUtils;
import com.collect.common.utils.ServletUtils;
import com.collect.framework.manager.AsyncManager;
import com.collect.framework.manager.factory.AsyncFactory;
import com.collect.framework.util.ShiroUtils;
import com.collect.project.system.model.User;
import com.collect.project.system.service.IUserService;
/**
 * 注册校验方法
 * 
 * @author ruoyi
 */
@Component
public class RegisterService
{
    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordService passwordService;

    /**
     * 注册
     */
    public String register(User user)
    {
        String msg = "", loginName=user.getLoginName(),username = user.getUserName(), password = user.getPassword();

        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA)))
        {
            msg = "验证码错误";
        }
        else if (UserConstants.USER_NAME_NOT_UNIQUE.equals(userService.checkLoginNameUnique(loginName)))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        }
        else
        {
            user.setSalt(ShiroUtils.randomSalt());
            user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
            boolean regFlag = userService.registerUser(user);
            if (!regFlag)
            {
                msg = "注册失败,请联系系统管理人员";
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }
}
