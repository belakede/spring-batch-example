package me.belakede.example.batch.reader;

import me.belakede.example.batch.Person;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
class PersonMapper extends BeanWrapperFieldSetMapper {
    PersonMapper() {
        setTargetType(Person.class);
        setCustomEditors(createCustomEditors());
    }

    private Map<?, ? extends PropertyEditor> createCustomEditors() {
        Map<Object, PropertyEditor> editorHashMap = new HashMap<>();
        editorHashMap.put(LocalDate.class, new LocalDateEditor());
        return editorHashMap;
    }
}
