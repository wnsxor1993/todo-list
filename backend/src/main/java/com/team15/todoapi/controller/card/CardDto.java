package com.team15.todoapi.controller.card;

import com.team15.todoapi.domain.Card;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CardDto {

	private Long id;
	private String title;
	private String content;
	private Long member_id;
	private LocalDateTime created_at;
	private LocalDateTime modified_at;
	private boolean delete_flag;
	private int section;

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Long getMember_id() {
		return member_id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getModified_at() {
		return modified_at;
	}

	public boolean isDelete_flag() {
		return delete_flag;
	}

	public int getSection() {
		return section;
	}

	public static CardDto from(Card card) {
		return new CardDto(card.getId(), card.getTitle(), card.getContent(), card.getMember_id(),
			card.getCreated_at(), card.getModified_at(), card.isDelete_flag(), card.getCardSectionCodeId());
	}

	public Card toEntity(){
		return new Card(id, title, content, member_id, created_at, modified_at, delete_flag, section);
	}

	public Card toEntityCreate(){
		return new Card(title, content, member_id, section);
	}
}
