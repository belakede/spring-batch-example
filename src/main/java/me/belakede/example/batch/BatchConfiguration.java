package me.belakede.example.batch;

import me.belakede.example.batch.writer.CandidateCsvItemWriter;
import me.belakede.example.batch.writer.CandidateJdbcBatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ItemReader<Person> reader;
    private final CompositeItemProcessor<Person, Candidate> processor;
    private final ItemWriter<Candidate> dbWriter;
    private final ItemWriter<Candidate> csvWriter;
    private final JobExecutionListener listener;

    @Autowired
    public BatchConfiguration(JobBuilderFactory jobBuilderFactory,
                              StepBuilderFactory stepBuilderFactory,
                              ItemReader<Person> reader,
                              CompositeItemProcessor<Person, Candidate> processor,
                              CandidateJdbcBatchItemWriter dbWriter,
                              CandidateCsvItemWriter csvWriter,
                              JobExecutionListener listener) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.reader = reader;
        this.processor = processor;
        this.dbWriter = dbWriter;
        this.csvWriter = csvWriter;
        this.listener = listener;
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importPersonJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(firstStep())
                .next(secondStep())
                .end()
                .build();
    }

    @Bean
    public Step firstStep() {
        return stepBuilderFactory.get("firstStep")
                .<Person, Candidate> chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(dbWriter)
                .build();
    }

    @Bean
    public Step secondStep() {
        return stepBuilderFactory.get("secondStep")
                .<Person, Candidate>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(csvWriter)
                .build();
    }
}
