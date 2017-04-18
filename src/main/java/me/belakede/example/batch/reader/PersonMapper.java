package me.belakede.example.batch.reader;

import me.belakede.example.batch.Person;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    private static final class LocalDateEditor extends PropertyEditorSupport {
        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public void setAsText(String text) throws IllegalArgumentException{
            setValue(LocalDate.parse(text, DATE_FORMATTER));
        }

        @Override
        public String getAsText() throws IllegalArgumentException {
            LocalDate value = (LocalDate) getValue();
            return value.format(DATE_FORMATTER);
        }
    }
}
