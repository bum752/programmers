package io.github.bum752.programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 베스트앨범
// https://programmers.co.kr/learn/courses/30/lessons/42579
public class BestAlbum {

	public int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> playsPerGenreMap = new HashMap<>();
		Map<String, List<Integer>> genreIdMap = new HashMap<>();
		Map<Integer, Integer> playsPerGenreIdMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			Integer playPerGenre = playsPerGenreMap.getOrDefault(genre, 0);
			playPerGenre += play;
			playsPerGenreMap.put(genre, playPerGenre);

			List<Integer> genreIdList = genreIdMap.getOrDefault(genre, new ArrayList<>());
			genreIdList.add(i);
			genreIdMap.put(genre, genreIdList);

			playsPerGenreIdMap.put(i, play);
		}

		Map<String, Integer> sortedPlaysPerGenreMap = playsPerGenreMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		Map<Integer, Integer> sortedPlaysPerGenreIdMap = playsPerGenreIdMap.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		List<String> genreList = new ArrayList<>(sortedPlaysPerGenreMap.keySet());
		List<Integer> answerList = new ArrayList<>();

		for (String genre : genreList) {
			List<Integer> genreIdList = genreIdMap.get(genre);
			genreIdList.sort(Collections.reverseOrder(Comparator.comparing(sortedPlaysPerGenreIdMap::get)));
			answerList.addAll(genreIdList.stream().limit(2).collect(Collectors.toList()));
		}

		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}

	@Test
	public void 테스트1() {
		String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
		int[] plays = new int[]{500, 600, 150, 800, 2500};

		Assertions.assertArrayEquals(new int[]{4, 1, 3, 0}, solution(genres, plays));
	}
}
