package com.basic.oop.exception.custom;

import javax.naming.Context;
import javax.swing.text.View;

import org.activiti.bpmn.model.Activity;
import org.activiti.bpmn.model.FlowElement;

public class MainActivity extends Activity{
	
	private HMApi hmApi;
	
	@Override
	public FlowElement clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
    public void method1(View v) {
        Context context = null;
        try {
            hmApi.method1();
        } catch (HMException e) {
            e.printStackTrace();
            ExceptionHandler.toastByHMException(context, e);
        }
    }

    public void method2(View v) {
    	Context context = null;
        try {
            hmApi.method2();
        } catch (HMException e) {
            e.printStackTrace();
            ExceptionHandler.toastByHMException(context, e);
        }
    }

    public void method3(View v) {
    	Context context = null;
        try {
            hmApi.method3();
        } catch (HMException e) {
            e.printStackTrace();
            ExceptionHandler.toastByHMException(context, e);
        }
    }

    public void method4(View v) {
    	Context context = null;
        try {
            hmApi.method4();
        } catch (HMException e) {
            e.printStackTrace();
            ExceptionHandler.toastByHMException(context, e);
        }
    }

}
