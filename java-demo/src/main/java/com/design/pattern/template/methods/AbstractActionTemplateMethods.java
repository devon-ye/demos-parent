package com.design.pattern.template.methods;

import java.util.List;

/**
 *
 * @author Devonmusa
 * @date 2017年7月6日
 */
public abstract class AbstractActionTemplateMethods {

	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int MODIFY = 3;
	public static final int GET = 4;

	public Object command(int i, Object obj) {

		switch (i) {
		case ADD:
			add(obj);
			return obj;
		case DELETE:
			delete((Long) obj);
			return obj;
		case MODIFY:
			return modify(obj);
		case GET:
			get((Long)obj);
		default:
			return null;

		}

	}

	public abstract void add(Object obj);

	public abstract void delete(Long id);

	public abstract Object modify(Object obj);

	public abstract Object get(Long id);

	public abstract List<Object> getList(List<Long> ids);

}
