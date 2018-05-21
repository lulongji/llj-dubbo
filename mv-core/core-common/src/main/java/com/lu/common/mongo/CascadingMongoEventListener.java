package com.lu.common.mongo;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.util.ReflectionUtils;

/**
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月22日 下午4:32:52
 */
public class CascadingMongoEventListener extends AbstractMongoEventListener<Object> {

	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public void onBeforeConvert(final Object source) {
		ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(Cascade.class)) {
					final Object fieldValue = field.get(source);
					DbRefFieldCallback callback = new DbRefFieldCallback();
					ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
					if (!callback.isIdFound()) {
						throw new MappingException("Cannot perform cascade save on child object without id set");
					}
					mongoTemplate.save(fieldValue);
				}
			}
		});
	}

	private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {
		private boolean idFound;

		public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
			ReflectionUtils.makeAccessible(field);
			if (field.isAnnotationPresent(Id.class)) {
				idFound = true;
			}
		}

		public boolean isIdFound() {
			return idFound;
		}
	}
}
