package com.possumus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PossumusRomanNumbersApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void shouldConvertArabicToRomanEndToEnd() {
		String url = "http://localhost:" + port + "/api/to-roman?number=1994";

		String response = restTemplate.getForObject(url, String.class);

		assertEquals("MCMXCIV", response);
	}

	@Test
	void shouldConvertRomanToArabicEndToEnd() {
		String url = "http://localhost:" + port + "/api/to-arabic?number=XXI";

		String response = restTemplate.getForObject(url, String.class);

		assertEquals("21", response);
	}
}

