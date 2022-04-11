package com.team15.todoapi.repository;

import com.team15.todoapi.domain.Card;
import java.util.List;

public interface CardRepository {
	List<Card> findAll();
	Card insert(Card card);
}
