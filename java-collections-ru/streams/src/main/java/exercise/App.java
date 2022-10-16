package exercise;

import java.util.List;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> list) {
        int hostYandex = (int) list.stream()
                .filter(email -> email.contains("@yandex.ru"))
                .count();

        int hostGmail = (int) list.stream()
                .filter(email -> email.contains("@gmail.com"))
                .count();

        int hostHotmail = (int) list.stream()
                .filter(email -> email.contains("@hotmail.com"))
                .count();
        return hostHotmail + hostGmail + hostYandex;
    }
}
// END
