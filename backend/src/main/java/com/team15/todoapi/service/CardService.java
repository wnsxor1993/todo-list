package com.team15.todoapi.service;

import com.team15.todoapi.controller.card.CardDto;
import com.team15.todoapi.domain.Card;
import com.team15.todoapi.repository.CardRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

	private final CardRepository cardRepository;

	public List<CardDto> findAll() {
		List<Card> cards = cardRepository.findAll();
		return cards.stream().map(CardDto::from)
			.collect(Collectors.toList());
	}

	public CardDto addCard(CardDto cardDto) {
		Card card = cardDto.toEntityCreate();
		return CardDto.from(cardRepository.insert(card));
	}
}
