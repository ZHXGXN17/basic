package com.basic.oop.exception;

/**
 * 毕老师用电脑上课，涉及对象 毕老师、电脑
 * 问题：蓝屏、冒烟
 *
 */
public class Demo02 {

}

class LanPingException extends Exception{
	LanPingException(String msg){
		super(msg);
	}
}

class MaoYanException extends Exception{
	MaoYanException(String msg){
		super(msg);
	}
}

class NoPlanException extends Exception{
	NoPlanException(String msg){
		super(msg);
	}
}

class Computer{
	private int state = 1;// 0 2
	
	public void run() throws LanPingException, MaoYanException{
		if(state == 1) {
			throw new LanPingException("电脑蓝屏啦!");
		}
		if(state == 2) {
			throw new MaoYanException("电脑冒烟啦!");
		}
		System.out.println("电脑运行!");
	}
	
	public void reset() {
		state = 0;
		System.out.println("电脑重启!");
	}
}
