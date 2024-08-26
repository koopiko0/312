package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
        private static final UserService userService = new UserServiceImpl();
        private static final User user1 = new User("Mitroy", "Gopit", (byte) 25);
        private static final User user2 = new User("Kris", "Kohsu", (byte) 13);
        private static  final  User user3 = new User("Itachi", "Uchiha", (byte) 21);

        public static final void main(String[] args) throws SQLException {
            userService.createUsersTable();

            userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
            userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
            userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

            System.out.println("Список всех пользователей:");
            for (User user : userService.getAllUsers()) {
                System.out.println(user);
            }

            userService.removeUserById(user2.getId());
            System.out.println("После удаления пользователя с id = " + user2.getId() + ":");
            for (User user : userService.getAllUsers()) {
                System.out.println(user);
            }

            userService.cleanUsersTable();
            System.out.println("После очистки таблиц");
        }

    }
