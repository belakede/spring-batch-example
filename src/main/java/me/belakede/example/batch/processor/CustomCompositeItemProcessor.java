package me.belakede.example.batch.processor;

import me.belakede.example.batch.Candidate;
import me.belakede.example.batch.Person;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CustomCompositeItemProcessor extends CompositeItemProcessor<Person, Candidate> {
    @Autowired
    public CustomCompositeItemProcessor(PersonItemProcessor personItemProcessor, CandidateFilterItemProcessor candidateFilterItemProcessor) {
        setDelegates(Arrays.asList(personItemProcessor, candidateFilterItemProcessor));
    }
}
