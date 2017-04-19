package me.belakede.example.batch.writer;

import me.belakede.example.batch.Candidate;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.stereotype.Component;

@Component
class CandidateFieldExtractor extends BeanWrapperFieldExtractor<Candidate> {
    private static final String[] FIELD_NAMES = {"fullName", "age", "town", "jobTitle"};
    CandidateFieldExtractor() {
        setNames(FIELD_NAMES);
    }
}
