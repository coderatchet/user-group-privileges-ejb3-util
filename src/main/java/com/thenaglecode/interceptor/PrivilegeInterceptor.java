package com.thenaglecode.interceptor;

import com.thenaglecode.services.UserHasPrivilegeService;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 5:40 PM
 * //todo implement
 */
public class PrivilegeInterceptor {

    @Resource
    SessionContext context;

    private static final UserHasPrivilegeService service = UserHasPrivilegeService.getUserHasPrivilegeService();

    @AroundInvoke
    public Object securityCheck(InvocationContext ctx) throws Exception {

    }
}
