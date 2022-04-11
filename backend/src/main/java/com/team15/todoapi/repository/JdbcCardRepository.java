package com.team15.todoapi.repository;

import static com.team15.todoapi.utils.TimeUtils.dateTimeOf;
import static com.team15.todoapi.utils.TimeUtils.timestampOf;

import com.team15.todoapi.domain.Card;
import java.sql.PreparedStatement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcCardRepository implements CardRepository{

	private SimpleJdbcInsert jdbcInsert;
	private final NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired private JdbcTemplate basicJdbcTempate;
	public JdbcCardRepository(DataSource dataSource) {
		jdbcInsert = new SimpleJdbcInsert(dataSource);
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Card> findAll() {
		return jdbcTemplate.query("select * from card", mapper);
	}

	public Card insert(Card card) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String query = "INSERT INTO card(id, title,content,created_at, modified_at,delete_flag, member_id,card_section_code_id) VALUES (null,?,?,?,?,?,?,?)";
		basicJdbcTempate.update(con -> {
			PreparedStatement ps = con.prepareStatement(query, new String[]{"id"});
			ps.setString(1, card.getTitle());
			ps.setString(2, card.getContent());
			ps.setTimestamp(3, timestampOf(card.getCreated_at()));
			ps.setTimestamp(4, timestampOf(card.getModified_at()));
			ps.setBoolean(5, card.isDelete_flag());
			ps.setLong(6, card.getMember_id());
			ps.setInt(7, card.getCardSectionCodeId());
			return ps;
		}, keyHolder);
		Number key = keyHolder.getKey();
		int id = key != null ? key.intValue() : -1;//
		return new Card();
	}
	private static RowMapper<Card> mapper = (rs, rowNum) -> new Card(
		rs.getLong("id"),
		rs.getString("title"),
		rs.getString("content"),
		rs.getLong("member_id"),
		dateTimeOf(rs.getTimestamp("created_at")),
		dateTimeOf(rs.getTimestamp("modified_at")),
			rs.getBoolean("delete_flag"),
			rs.getInt("section")
			);
}
