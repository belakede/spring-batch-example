package me.belakede.example.batch.writer;

import me.belakede.example.batch.Candidate;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class CandidateJdbcBatchItemWriter extends JdbcBatchItemWriter<Candidate> {
    private static final String INSERT_SQL = "INSERT INTO candidates(full_name, age, town, job_title) VALUES(:fullName, :age, :town, :jobTitle)";
    private static final BeanPropertyItemSqlParameterSourceProvider<Candidate> ITEM_SQL_PARAMETER_SOURCE_PROVIDER = new BeanPropertyItemSqlParameterSourceProvider<>();

    @Autowired
    public CandidateJdbcBatchItemWriter(DataSource dataSource) {
        setItemSqlParameterSourceProvider(ITEM_SQL_PARAMETER_SOURCE_PROVIDER);
        setSql(INSERT_SQL);
        setDataSource(dataSource);
    }
}
