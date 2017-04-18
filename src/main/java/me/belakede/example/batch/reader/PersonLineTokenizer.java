package me.belakede.example.batch.reader;

import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

@Component
class PersonLineTokenizer extends DelimitedLineTokenizer {
    private static final String[] FIELD_NAMES = {"firstName", "lastName", "dateOfBirth",
            "jobTitle", "postalCode", "city", "address", "phoneNumber"};

    PersonLineTokenizer() {
        setNames(FIELD_NAMES);
    }
}
