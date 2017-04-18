package me.belakede.example.batch.reader;

import me.belakede.example.batch.Person;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class PersonLineMapper extends DefaultLineMapper<Person> {
    @Autowired
    public PersonLineMapper(PersonLineTokenizer lineTokenizer, PersonMapper mapper) {
        setLineTokenizer(lineTokenizer);
        setFieldSetMapper(mapper);
    }
}
