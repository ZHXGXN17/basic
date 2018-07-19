package com.basic.reflection.annoation.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.basic.reflection.service.ViewInject;

import android.app.Activity;
import android.view.View;

/**
 * 注解小框架
 * 
 * @author robin
 *
 */
public class ViewUtils {
	
	public static void inject(Activity activity) throws IllegalAccessException{
		bindView(activity);	
	}
	
	private static void bindView(Activity activity) throws IllegalAccessException{
		Field[] fields = activity.getClass().getDeclaredFields();
		for(Field field : fields) {
			ViewInject viewInject = field.getAnnotation(ViewInject.class);
			if(viewInject != null) {
				int resId = viewInject.value();
				View view = activity.findViewById(resId);
				field.setAccessible(true);
				field.set(activity, view);
			}
		}
	}
	
	public static void onClick(final Activity activity) {
		Method[] methods = activity.getClass().getDeclaredMethods();
		for(final Method method : methods) {
//			Onclick onclick = method.getAnnotation(Onclick.class);
//			if (onclick != null){
//              int resId = onclick.value();
//              final View view = activity.findViewById(resId);
//              view.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//                      method.setAccessible(true);
//                      try {
//                          method.invoke(activity,view);
//                      } catch (IllegalAccessException e) {
//                          e.printStackTrace();
//                      } catch (InvocationTargetException e) {
//                          e.printStackTrace();
//                      }
//                  }
//              });
//          }
		}
	}

}
