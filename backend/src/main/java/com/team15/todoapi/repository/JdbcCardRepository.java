package com.team15.todoapi.repository;

import com.team15.todoapi.domain.Card;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCardRepository implements CardRepository{

	private final JdbcTemplate jdbcTemplate;

	public JdbcCardRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Card> findAll() {
		return jdbcTemplate.query(
			"SELECT card.id, "
				+ "title, "
				+ "content, "
				+ "modified_at, "
				+ "user_id, "
				+ "card_section_code_id "
				+ "from card , member "
				+ "where card.member_id = member.id "
				+ "and  delete_flag = false "
				+ "order by modified_at desc", cardRowMapper());
	}

	private RowMapper<Card> cardRowMapper(){
		return (rs, rowNum) -> {
			Card card = new Card(rs.getString("title"),rs.getString("title"));
			return card;
		};
	}
}
