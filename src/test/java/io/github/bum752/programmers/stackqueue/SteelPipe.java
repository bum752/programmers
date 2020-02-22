package io.github.bum752.programmers.stackqueue;

import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 쇠막대기
// https://programmers.co.kr/learn/courses/30/lessons/42585
public class SteelPipe {

	public int solution(String arrangement) {
		int answer = 0;
		char[] arrangementChars = arrangement.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arrangementChars.length; i++) {
			if (arrangement.charAt(i) == '(') {
				if (i < arrangement.length() - 1 && arrangement.charAt(i + 1) == ')') {
					answer += stack.size();
					i++;
				} else {
					stack.push('(');
				}
			} else if (arrangement.charAt(i) == ')') {
				stack.pop();
				answer++;
			}
		}

		return answer;
	}

	@Test
	public void 테스트1() {
		String arrangement = "()(((()())(())()))(())";
		Assertions.assertEquals(17, solution(arrangement));
	}

	@Test
	public void 테스트2() {
		String arrangement = "(()()())";
		Assertions.assertEquals(4, solution(arrangement));
	}
}
