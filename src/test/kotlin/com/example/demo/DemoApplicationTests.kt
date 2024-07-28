package com.example.demo

import org.junit.jupiter.api.Test


class DemoApplicationTests {

	@Test
	fun contextLoads() {
		println(myAtoi("42"))
		println(myAtoi("   -42"))
		println(myAtoi("4193 with words"))
	}

	fun myAtoi(s: String): Int {
		var result: Long = 0
		var isNegative = false
		var isStarted = false

		for (c in s) {
			if (c == ' ' && !isStarted) {
				continue
			}
			if (c == '-' && !isStarted) {
				isNegative = true
				isStarted = true
				continue
			}
			if (c == '+' && !isStarted) {
				isNegative = false
				isStarted = true
				continue
			}
			if (c.isDigit()) {
				isStarted = true
				result = result * 10 + (c - '0')
				if (result > Int.MAX_VALUE) {
					return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
				}
			} else {
				break
			}

		}

		if (isNegative) {
			return -result.toInt()
		}

		return result.toInt()
	}
}
