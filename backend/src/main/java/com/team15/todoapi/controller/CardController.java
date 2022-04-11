package com.team15.todoapi.controller;

import com.team15.todoapi.controller.card.CardDto;
import com.team15.todoapi.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "CardController")
@RestController
@Slf4j
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

	private final CardService cardService;

	@ApiResponse(code = 401,
		message = "상태코드 메세지 테스트")
	@GetMapping
	public List<CardDto> cards() {
		log.info("로그 남기는 법");
		return cardService.findAll();
	}

	@PostMapping
	public CardDto addCard(@RequestBody CardDto cardDto) {
		return cardService.addCard(cardDto);
	}
}
