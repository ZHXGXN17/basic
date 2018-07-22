package com.basic.reflection.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.basic.reflection.proxy.dao.Advice;

public class ProxyFactoryBean {
	
	private Object mTarget;
	
	private Advice mAdvice;
	
	public Object getProxy() {
		Object proxy = Proxy.newProxyInstance(mTarget.getClass().getClassLoader(), 
				mTarget.getClass().getInterfaces(), mHandler);
		return proxy;
	}
	
	private InvocationHandler mHandler = new InvocationHandler() {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			mAdvice.beforeMethod(method);
			Object result = method.invoke(mTarget, args);
			mAdvice.afterMethod(method);
			return result;
		}
	};
	
	public void setTarget(Object target) {
        mTarget = target;
    }

    public void setAdvice(Advice advice) {
        mAdvice = advice;
    }

    public Object getTarget() {
        return mTarget;
    }

    public Advice getAdvice() {
        return mAdvice;
    }


}
