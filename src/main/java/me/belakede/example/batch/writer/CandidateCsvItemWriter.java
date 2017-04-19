package me.belakede.example.batch.writer;

import me.belakede.example.batch.Candidate;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CandidateCsvItemWriter extends FlatFileItemWriter<Candidate> {
    private static final String CSV_COLUMN_NAMES[] = {"full_name","age", "town", "job_title"};

    public CandidateCsvItemWriter(@Value("${me.belakede.batch.output.csv}") String resource,
                                  @Value("${me.belakede.batch.output.separator}") String separator,
                                  CandidateLineAggregator aggregator) {
        setShouldDeleteIfExists(true);
        setLineAggregator(aggregator);
        setResource(new FileSystemResource(resource));
        setHeaderCallback(writer -> writer.write(Arrays.stream(CSV_COLUMN_NAMES).collect(Collectors.joining(separator))));
    }
}
