package io.github.bum752.programmers.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 기능개발
// https://programmers.co.kr/learn/courses/30/lessons/42586
public class Feature {

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answerList = new ArrayList<>();
		Queue<Integer> progressTaskQueue = new LinkedList<>();
		Queue<Integer> taskQueue = new LinkedList<>();

		for (int i = 0; i < progresses.length; i++) {
			int progress = progresses[i];
			int speed = speeds[i];

			int dates = (100 - progress) / speed;
			if ((100 - progress) % speed > 0) {
				dates += 1;
			}

			taskQueue.add(dates);
		}

		while (!taskQueue.isEmpty()) {
			Integer currentTaskDates = taskQueue.poll();

			if (!progressTaskQueue.isEmpty()) {
				Integer prevTaskDates = progressTaskQueue.peek();
				if (prevTaskDates < currentTaskDates) {
					answerList.add(progressTaskQueue.size());
					progressTaskQueue.clear();
				}
			}
			progressTaskQueue.add(currentTaskDates);
		}
		answerList.add(progressTaskQueue.size());

		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}

	@Test
	public void 테스트1() {
		int[] progresses = new int[]{93, 30, 55};
		int[] speeds = new int[]{1, 30, 5};

		Assertions.assertArrayEquals(new int[]{2, 1}, solution(progresses, speeds));
	}

	@Test
	public void 테스트2() {
		int[] progresses = new int[]{93, 30, 97};
		int[] speeds = new int[]{1, 30, 5};

		Assertions.assertArrayEquals(new int[]{3}, solution(progresses, speeds));
	}

	@Test
	public void 테스트3() {
		int[] progresses = new int[]{40, 93, 30, 55, 60, 65};
		int[] speeds = new int[]{60, 1, 30, 5, 10, 7};

		Assertions.assertArrayEquals(new int[]{1, 2, 3}, solution(progresses, speeds));
	}

	@Test
	public void 테스트4() {
		int[] progresses = new int[]{93, 30, 55, 60, 40, 65};
		int[] speeds = new int[]{1, 30, 5, 10, 60, 7};

		Assertions.assertArrayEquals(new int[]{2, 4}, solution(progresses, speeds));
	}

	@Test
	public void 테스트5() {
		int[] progresses = new int[]{99, 99, 99, 99, 99};
		int[] speeds = new int[]{1, 1, 1, 1, 1};

		Assertions.assertArrayEquals(new int[]{5}, solution(progresses, speeds));
	}
}
