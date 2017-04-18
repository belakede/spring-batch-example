package me.belakede.example.batch.reader;


import me.belakede.example.batch.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class PersonCsvItemReader extends FlatFileItemReader<Person> {
    @Autowired
    public PersonCsvItemReader(@Value("${me.belakede.batch.input.csv}") String resource, PersonLineMapper lineMapper) {
        setResource(new ClassPathResource(resource));
        setLineMapper(lineMapper);
        setLinesToSkip(1);                              // skip the first line
    }
}