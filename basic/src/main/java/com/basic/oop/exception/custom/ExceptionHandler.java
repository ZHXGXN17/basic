package com.basic.oop.exception.custom;

import javax.naming.Context;

public class ExceptionHandler {
	
	/**
	 * 根据不用HMException给用户具体的提示
	 */
	public static void toastByHMException(Context context, HMException e) {
		int errCode = 0;
		// errCode 具体化
		if(e instanceof HMAException) {
			errCode = 1;
		}else if(e instanceof HMBException) {
			errCode = 2;
		}else if(e instanceof HMCException) {
			errCode = 3;
		}else if(e instanceof HMDException) {
			errCode = 4;
		}
		// 根据不用的errCode给用户提示
		toastByErrCode(context, errCode);
	}
	
	
	private static void toastByErrCode(Context context, int errCode) {
		String content = "";
		switch(errCode) {
		case 1:
			content = "程序出现了HMAException";
			break;
		case 2:
			content = "程序出现了HMBException";
			break;
		case 3:
			content = "程序出现了HMCException";
			break;
		case 4:
			content = "程序出现了HMDException";
			break;
		default:
			break;
		}
		
//		Toast.makeText(context, content, 0).show();
	}
	
	
}
