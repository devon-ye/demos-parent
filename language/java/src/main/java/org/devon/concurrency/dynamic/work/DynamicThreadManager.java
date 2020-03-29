package org.devon.concurrency.dynamic.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @author devon.ye
 * @datetime 2020/2/22 12:50 下午
 * @since
 */
public abstract class DynamicThreadManager<Work extends AbstractTask> {

	private List<Work> workList;

	public void init() {

	}


	public void addWorks(int count) {
		for (int i = 0; i < count; i++) {
			addWork();
		}
	}

	private synchronized void addWork() {
		if (workList == null) {
			workList = new ArrayList<>();
		}

		int index = workList.size();
	}

	public void removeWorks(int count) {
		for (int i = 0; i < count; i++) {
			removeWork();
		}
	}


	private synchronized void removeWork() {

	}
}
