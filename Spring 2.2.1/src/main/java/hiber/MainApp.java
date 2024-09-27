package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Oleg", "Frolov", "olezhon@mail.com");
        User user2 = new User("Kirill", "Rusov", "sgdg@mail.com");
        User user3 = new User("Ira", "Shwera", "zalup@ya.com");
        User user4 = new User("Islam", "Egorov", "boimail@mail.com");

        Car car1 = new Car("Lada", 21114);
        Car car2 = new Car("Ford", 2);
        Car car3 = new Car("Fiat", 660);
        Car car4 = new Car("Kia", 213);

        userService.add(user1.setCar(car1).setUser(user1));
        userService.add(user2.setCar(car2).setUser(user2));
        userService.add(user3.setCar(car3).setUser(user3));
        userService.add(user4.setCar(car4).setUser(user4));

        for (User user : userService.listUsers()) {
            System.out.println(user + " " + user.getCar());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Машиной владеет" +  userService.getUserByCar("Ford", 2));
        context.close();
    }
}
