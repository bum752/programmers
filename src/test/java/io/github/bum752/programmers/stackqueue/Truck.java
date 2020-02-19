package io.github.bum752.programmers.stackqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Truck {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> truckWeightQueue = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));
		Queue<Integer> truckWeightOnBridgeQueue = new LinkedList<>(Collections.nCopies(bridge_length, 0));

		while (!truckWeightOnBridgeQueue.isEmpty()) {
			truckWeightOnBridgeQueue.poll();
			answer++;

			if (!truckWeightQueue.isEmpty()) {
				int sumOfTruckWeightOnBridge = truckWeightOnBridgeQueue.stream().mapToInt(Integer::intValue).sum();

				if (sumOfTruckWeightOnBridge + truckWeightQueue.peek() <= weight) {
					truckWeightOnBridgeQueue.add(truckWeightQueue.poll());
				} else {
					truckWeightOnBridgeQueue.add(0);
				}
			}
		}

		return answer;
	}

	@Test
	public void 테스트1() {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = new int[]{7, 4, 5, 6};
		Assertions.assertEquals(8, solution(bridge_length, weight, truck_weights));
	}

	@Test
	public void 테스트2() {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = new int[]{10};
		Assertions.assertEquals(101, solution(bridge_length, weight, truck_weights));
	}

	@Test
	public void 테스트3() {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		Assertions.assertEquals(110, solution(bridge_length, weight, truck_weights));
	}

	@Test
	public void 테스트4() {
		int bridge_length = 1;
		int weight = 2;
		int[] truck_weights = new int[]{1, 1, 1};
		Assertions.assertEquals(4, solution(bridge_length, weight, truck_weights));
	}

	@Test
	public void 테스트5() {
		int bridge_length = 1;
		int weight = 1;
		int[] truck_weights = new int[]{1, 1, 1};
		Assertions.assertEquals(4, solution(bridge_length, weight, truck_weights));
	}

	@Test
	public void 테스트6() {
		int bridge_length = 4;
		int weight = 2;
		int[] truck_weights = new int[]{1, 1, 1, 1};
		Assertions.assertEquals(10, solution(bridge_length, weight, truck_weights));
	}
}
