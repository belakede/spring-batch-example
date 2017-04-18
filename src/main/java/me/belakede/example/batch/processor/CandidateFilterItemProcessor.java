package me.belakede.example.batch.processor;

import me.belakede.example.batch.Candidate;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
class CandidateFilterItemProcessor implements ItemProcessor<Candidate, Candidate> {
    private static final String ENGINEER = "engineer";
    private static final int AGE_LIMIT = 24;

    @Override
    public Candidate process(Candidate candidate) throws Exception {
        Candidate result = null;
        if (candidate.getAge() > AGE_LIMIT && candidate.getJobTitle().toLowerCase().contains(ENGINEER)) {
            result = candidate;
        }
        return result;
    }
}
