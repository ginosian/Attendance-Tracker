package com.attendance_tracker.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service("api_remeber_me_service")
public class RememberMeServicesImpl implements RememberMeServices {

    @Override
    public Authentication autoLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return null;
    }

    @Override
    public void loginFail(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println();
    }

    @Override
    public void loginSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        System.out.println();
    }
}
