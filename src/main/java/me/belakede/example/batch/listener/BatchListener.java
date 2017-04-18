package me.belakede.example.batch.listener;

import me.belakede.example.batch.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchListener extends JobExecutionListenerSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchListener.class);
    private static final String QUERY = "SELECT full_name, age, town, job_title FROM candidates";
    private final JdbcTemplate jdbcTemplate;
    private final CandidateRowMapper rowMapper;

    @Autowired
    public BatchListener(JdbcTemplate jdbcTemplate, CandidateRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            LOGGER.info("Job finished. Stored candidates: ");
            List<Candidate> candidates = jdbcTemplate.query(QUERY, rowMapper);
            candidates.forEach(candidate -> LOGGER.info("{}", candidate));
            LOGGER.info("Total: {}", candidates.size());
        } else {
            LOGGER.info("Job failed.");
        }
    }

}
