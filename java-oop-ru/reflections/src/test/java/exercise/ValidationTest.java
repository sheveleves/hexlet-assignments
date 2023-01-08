package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;

class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    @Test
    void testAdvancedValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        Map<String, List<String>> result1 = Validator.advancedValidate(address1);
        Map<String, List<String>> expected1 = Map.of("city", List.of("length less than 4"));
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> result2 = Validator.advancedValidate(address2);
        List<String> street2 = List.of("can not be null");
        Map<String, List<String>> expected2 = Map.of("street", street2);
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("UK", null, null, "7", "");
        Map<String, List<String>> result3 = Validator.advancedValidate(address3);
        List<String> country3 = List.of("length less than 3");
        List<String> city3 = List.of("can not be null", "length less than 4");
        List<String> street3 = List.of("can not be null");
        Map<String, List<String>> expected3 = Map.of("country", country3, "city", city3, "street", street3);
        assertThat(result3).isEqualTo(expected3);

        Address address4 = new Address("China", "Hong Kong", "Dried Seafood", "54",
                null);
        Map<String, List<String>> result4 = Validator.advancedValidate(address1);
        Map<String, List<String>> expected4 = Map.of();
        assertThat(result1).isEqualTo(expected1);
    }
    // END
}
