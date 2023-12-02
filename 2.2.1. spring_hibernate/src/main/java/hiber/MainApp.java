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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("Mazda",5)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("Vaz",2107)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("BMW",3)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("MB",210)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
   List<User> usersByCar=userService.getUserByCar("BMW",3);
      for (User user:usersByCar){
         System.out.println(user);
      }
      context.close();
   }
}
