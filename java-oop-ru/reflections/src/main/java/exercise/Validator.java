package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> listField = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        listField.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(String.format("The field %s must not be empty", field.getName()));
                }
            }
        }
        return listField;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        List<String> listError = new ArrayList<>();
        Map<String, List<String>> mapField = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            listError.clear();
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (notNull != null) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        listError.add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    System.out.printf("The field %s must not be empty%n", field.getName());
                }
            }
            MinLength minLength = field.getAnnotation(MinLength.class);
            if (minLength != null) {
                try {
                    field.setAccessible(true);
                    if ((field.get(address) == null) || ((String) field.get(address)).length()
                            < minLength.minLength()) {
                        String msgError = String.format("length less than %d", minLength.minLength());
                        listError.add(msgError);
                    }
                } catch (IllegalAccessException e) {
                    System.out.printf("The field %s length less than %d%n", field.getName(), minLength.minLength());
                }
            }
            if (!listError.isEmpty()) {
                mapField.put(field.getName(), new ArrayList<>(listError));
            }
        }
        return mapField;
    }
}
// END
