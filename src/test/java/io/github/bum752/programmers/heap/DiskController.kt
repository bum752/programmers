package io.github.bum752.programmers.heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

/**
 * [디스크 컨트롤러](https://programmers.co.kr/learn/courses/30/lessons/42627)
 */
class DiskController {

    fun solution(jobs: Array<IntArray>): Int {
        // 요청시간 오름차순 정렬
        jobs.sortBy { it[0] }

        var processedJobs = 0
        var remainJobIndex = 0
        var currentTime = 0
        var totalElapsedTime = 0

        // 작업 소요시간 오름차순 우선순위 큐
        val priorityQueue = PriorityQueue<IntArray> { o1, o2 -> o1[1] - o2[1] }

        while (processedJobs < jobs.size) {
            // 작업 수행 중 요청된 작업을 큐에 추가
            while (remainJobIndex < jobs.size && jobs[remainJobIndex][0] <= currentTime) {
                priorityQueue.add(jobs[remainJobIndex])
                remainJobIndex++
            }

            if (priorityQueue.isNotEmpty()) {
                val job = priorityQueue.poll()
                totalElapsedTime += currentTime + job[1] - job[0]
                currentTime += job[1]
                processedJobs++
            } else {
                currentTime = jobs[remainJobIndex][0]
            }
        }

        return totalElapsedTime / jobs.size
    }

    @Test
    fun `테스트1`() {
        val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))
        Assertions.assertEquals(9, solution(jobs))
    }

    @Test
    fun `테스트2`() {
        val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(3, 9), intArrayOf(12, 6))
        Assertions.assertEquals((3 + 9 + 6) / 3, solution(jobs))
    }

    @Test
    fun `테스트3`() {
        val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(4, 9), intArrayOf(13, 6))
        Assertions.assertEquals((3 + 9 + 6) / 3, solution(jobs))
    }
}
