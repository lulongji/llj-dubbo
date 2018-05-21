package com.lu.common.mongo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月22日 下午4:32:37
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Cascade {
	CascadeType cascadeType() default CascadeType.NONE;
}