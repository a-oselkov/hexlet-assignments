package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    int index = field.toString().lastIndexOf(".");
                    String result = field.toString().substring(index + 1);
                    notValidFields.add(result);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return notValidFields;
    }
}
// END
