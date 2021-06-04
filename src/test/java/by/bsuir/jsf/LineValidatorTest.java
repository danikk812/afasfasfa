package by.bsuir.jsf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class LineValidatorTest {

    @Test
    void validate() {
        String line = "1 23 4 434 3434 3";
        Pattern pattern = Pattern.compile("^([0-9]| )+");
        Assertions.assertTrue(pattern.matcher(line).find());
    }
}