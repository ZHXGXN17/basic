package com.basic.oop.exception.custom;

public class HMApi {
	
	public void method1() throws HMException{
		// 模拟，某一个时刻出现了HMAException
		throw new HMAException();
	}
	
	public void method2() throws HMException{
		// 模拟，某一个时刻出现了HMBException
		throw new HMBException();
	}
	
	public void method3() throws HMException{
		// 模拟，某一个时刻出现了HMCException
		throw new HMCException();
	}
	
	public void method4() throws HMException{
		// 模拟， 某一个时刻出现了HMDException
		throw new HMDException();
	}

}
