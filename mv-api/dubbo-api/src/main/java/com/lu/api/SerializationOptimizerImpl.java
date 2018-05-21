package com.lu.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SerializationOptimizerImpl implements SerializationOptimizer {
	@SuppressWarnings("rawtypes")
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<Class>();
		// common
		classes.add(byte.class);
		classes.add(char.class);
		classes.add(short.class);
		classes.add(int.class);
		classes.add(long.class);
		classes.add(double.class);
		classes.add(boolean.class);
		classes.add(Byte.class);
		classes.add(Character.class);
		classes.add(Short.class);
		classes.add(Integer.class);
		classes.add(Long.class);
		classes.add(Double.class);
		classes.add(Boolean.class);
		classes.add(String.class);
		classes.add(Map.class);
		classes.add(HashMap.class);
		classes.add(List.class);
		classes.add(ArrayList.class);
		classes.add(Timestamp.class);

		return classes;
	}

}