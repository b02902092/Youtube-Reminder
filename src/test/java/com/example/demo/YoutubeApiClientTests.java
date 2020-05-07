package com.example.demo;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class YoutubeApiClientTests {
	static String youtubeApiKey = System.getProperty("youtubeApiKey");

	@Test
	void testNullKey() {
		assertThrows(UncheckedIOException.class, () -> YoutubeApiClient.getVideos("", 5, "JP"));
	}

	@RepeatedTest(10)
	void testRandomKey() {
		String randomString = RandomStringUtils.randomAlphanumeric(youtubeApiKey.length());
		assertThrows(UncheckedIOException.class, () -> YoutubeApiClient.getVideos(randomString, 5, "JP"));
	}

	@Test
	void testMaxResultOver50() {
		assertThrows(IllegalArgumentException.class, () -> YoutubeApiClient.getVideos(youtubeApiKey, 100, "JP"));
	}

	@Test
	void testMaxResultBelow0() {
		assertThrows(IllegalArgumentException.class, () -> YoutubeApiClient.getVideos(youtubeApiKey, 0, "JP"));
	}

	/*
	TODO [How to check the region code.]
	@RepeatedTest(10)
	void testIllegalRegionCode() {
		String randomString = RandomStringUtils.randomAlphanumeric(2);
		assertThrows(UncheckedIOException.class, () -> YoutubeApiClient.getVideos(youtubeApiKey, 5, randomString));
	}
	 */

}
