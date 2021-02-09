package mate.academy;

import java.util.List;
import mate.academy.config.AppConfig;
import mate.academy.model.User;
import mate.academy.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        User mike = new User();
        mike.setName("Mike");
        mike.setAge(30);

        User olia = new User();
        olia.setName("Olia");
        olia.setAge(25);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(mike);
        userService.add(olia);
        List<User> users = userService.listUsers();
        users.forEach(System.out::println);
    }
}
