package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Nick", "Pom", "nickpom@mail.ru");
        User user2 = new User("Mick", "Rom", "mickrom@mail.ru");
        User user3 = new User("Dick", "Gom", "dickgom@mail.ru");

        user1.setCar(new Car("Toyota", 1));
        user2.setCar(new Car("Jeep", 2));
        user3.setCar(new Car("KIA", 3));

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Cars model = " + user.getCar().getModel());
            System.out.println("Cars series = " + user.getCar().getSeries());
            System.out.println();

        }
        System.out.println(userService.findingUsers("Toyota", 1));

        context.close();
    }
}
