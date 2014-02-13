/**
 * 
 */
package com.siminglun.ssh.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @author 司明仑 --2014-1-7
 *
 */
public class ValidateLogin extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actioninvocation)
			throws Exception {
		System.out.println(">>进入拦截器");
		if (ActionContext.getContext().getSession().get("user") != null) {
			System.out.println("用户已经登录");
			return actioninvocation.invoke();
		} else {
			System.out.println("用户未登录");
			return Action.LOGIN;
		}
	}

}
