package com.team15.todoapi.domain;

import java.time.LocalDateTime;


public class Card {

	private Long id;
	private String title;
	private String content;
	private Long member_id;
	private LocalDateTime created_at;
	private LocalDateTime modified_at;
	private boolean delete_flag;
	private int cardSectionCodeId;

	public Card(){};

	public Card(Long id, String title, String content, Long member_id,
		LocalDateTime created_at, LocalDateTime modified_at, boolean delete_flag, int cardSectionCodeId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.member_id = member_id;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.delete_flag = delete_flag;
		this.cardSectionCodeId = cardSectionCodeId;
	}

	public Card(String title, String content, Long member_id, int cardSectionCodeId) {
		LocalDateTime now = LocalDateTime.now();
		this.title = title;
		this.content = content;
		this.member_id = member_id;
		this.created_at = now;
		this.modified_at = now;
		this.delete_flag = false;
		this.cardSectionCodeId = cardSectionCodeId;
	}

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

	public int getCardSectionCodeId() {
		return cardSectionCodeId;
	}
}
