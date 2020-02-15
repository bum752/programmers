package io.github.bum752.programmers.hash;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577
public class PhoneBook {

	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			if (phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}

		return true;
	}

	@Test
	public void 테스트1() {
		String[] phone_book = {"119", "97674223", "1195524421"};
		Assertions.assertFalse(solution(phone_book));
	}

	@Test
	public void 테스트2() {
		String[] phone_book = {"123", "456", "789"};
		Assertions.assertTrue(solution(phone_book));
	}

	@Test
	public void 테스트3() {
		String[] phone_book = {"12", "123", "1235", "567", "88"};
		Assertions.assertFalse(solution(phone_book));
	}
}
