package me.belakede.example.batch.writer;

import me.belakede.example.batch.Candidate;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class CandidateLineAggregator extends DelimitedLineAggregator<Candidate> {
    @Autowired
    public CandidateLineAggregator(@Value("${me.belakede.batch.output.separator}") String separator,
                                   CandidateFieldExtractor extractor) {
        setFieldExtractor(extractor);
        setDelimiter(separator);
    }
}
