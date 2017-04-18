package me.belakede.example.batch.processor;

import me.belakede.example.batch.Candidate;
import me.belakede.example.batch.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
class PersonItemProcessor implements ItemProcessor<Person, Candidate> {
    @Override
    public Candidate process(Person person) throws Exception {
        Candidate candidate = new Candidate();
        candidate.setFullName(person.getLastName() + ", " + person.getFirstName());
        candidate.setAge(person.getDateOfBirth().until(LocalDate.now()).getYears());
        candidate.setTown(person.getCity());
        candidate.setJobTitle(person.getJobTitle());
        return candidate;
    }
}
