package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Util {
    public static SessionFactory getConnection() {
            final String driver = "com.mysql.cj.jdbc.Driver";
            final String host = "jdbc:mysql://localhost:3306/pp_1";
            final String login = "root";
            final String password = "root";
            SessionFactory sessionFactory = null;

        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class", driver)
                    .setProperty("hibernate.connection.url", host)
                    .setProperty("hibernate.connection.username", login)
                    .setProperty("hibernate.connection.password", password)
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass(User.class)
                    .setProperty("hibernate.c3p0.min_size","5")
                    .setProperty("hibernate.c3p0.max_size","200")
                    .setProperty("hibernate.c3p0.max_statements","200");

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
    }
