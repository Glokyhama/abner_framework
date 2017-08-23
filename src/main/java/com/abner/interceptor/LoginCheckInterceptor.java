package com.abner.interceptor;

import com.abner.service.core.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    public CoreService coreService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getParameter("token");
//        Map<String, Object> data;
//        try {
//            if (StringUtils.isBlank(token)) {
//                throw new BusinessException("pls check login param. token:" + token);
//            }
//            String userId = coreService.checkUserToken(token);
//            String requestUri = request.getRequestURI();
//            StringBuffer sb = new StringBuffer();
//            String userIp = NetUtil.getCurrentLoginUserIp(request);
//
//            sb.append(userId).append(CommonConstant.COMMON_VERTICAL_STR).append(userIp).append(CommonConstant
//                    .COMMON_VERTICAL_STR).append(token).append(CommonConstant.COMMON_VERTICAL_STR).append(requestUri);
//
//            Enumeration e = request.getParameterNames();
//            int count = 0;//计数器，信息用|分隔，参数用&分隔
//            while (e.hasMoreElements()) {
//                String paramName = (String) e.nextElement();
//                String paramValue = request.getParameter(paramName) == null ? null : StringUtils
//                        .trimToEmpty(request.getParameter(paramName));
//                if (StringUtils.isNotBlank(paramName)) {
//                    if (count == 0) {
//                        sb.append("?");
//                    } else {
//                        sb.append(CommonConstant.COMMON_AND_STR);
//                    }
//                    sb.append(paramName).append(CommonConstant.COMMON_EQUAL_STR).append(paramValue);
//                    count++;
//                }
//            }
//            userAccessLog.info(sb.toString());
//            if (userId != null) {
//                return true;
//            }
//            data = CommonUtil.asMap("code", ResultConstant.TOKEN_ERROR, "msg", "认证失败");
//        } catch (IllegalArgumentException | IllegalStateException e) {
//            log.info(String.format("认证失败，uri[%s], msg[%s], token[%s]", request.getRequestURI(),
//                    e.getMessage(), token), e);
//            data = CommonUtil.asMap("code", -1, "msg", e.getMessage(), "resp", "认证失败");
//        } catch (Exception e) {
//            log.info(String.format("认证失败，uri[%s], msg[%s], token[%s]", request.getRequestURI(),
//                    e.getMessage(), token), e);
//            data = CommonUtil.asMap("code", -1, "msg", "系统繁忙", "resp", "系统繁忙");
//        }
//        OutputUtils.renderJson(data);
//        return false;
        return false;
    }


}
