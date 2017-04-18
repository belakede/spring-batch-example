package me.belakede.example.batch.listener;

import me.belakede.example.batch.Candidate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class CandidateRowMapper implements RowMapper<Candidate> {
    private static final String FULL_NAME_COLUMN = "full_name";
    private static final String JOB_TITLE_COLUMN = "job_title";
    private static final String TOWN_COLUMN = "town";
    private static final String AGE_COLUMN = "age";

    @Override
    public Candidate mapRow(ResultSet resultSet, int i) throws SQLException {
        Candidate candidate = new Candidate();
        candidate.setFullName(resultSet.getString(FULL_NAME_COLUMN));
        candidate.setAge(resultSet.getInt(AGE_COLUMN));
        candidate.setTown(resultSet.getString(TOWN_COLUMN));
        candidate.setJobTitle(resultSet.getString(JOB_TITLE_COLUMN));
        return candidate;
    }
}
