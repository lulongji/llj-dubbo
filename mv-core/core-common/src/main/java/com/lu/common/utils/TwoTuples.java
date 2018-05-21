package com.lu.common.utils;

/**
 * 二元组
 * 
 * @author lu
 */
public class TwoTuples<T, E> {
	private T first;
	private E second;

	public TwoTuples(T first, E second) {
		super();
		this.first = first;
		this.second = second;
	}

	public TwoTuples() {

	}

	public T first() {
		return first;
	}

	public E second() {
		return second;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(E second) {
		this.second = second;
	}
}
