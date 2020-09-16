package counselling.com;


import models.Appointments;
import models.Clients;
import models.Counsellors;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateHelper {

    private static SessionFactory sessionFactory;

    private static SessionFactory createSessionFactory(){


        Configuration configuration = new Configuration();

        //configuration.configure("hibernate.cfg.xml");

        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/db_counselling?useSSL=false&serverTimezone=UTC");
        properties.setProperty(Environment.USER, "root");
        properties.setProperty(Environment.PASS, "");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Counsellors.class);
        configuration.addAnnotatedClass(Clients.class);
        configuration.addAnnotatedClass(Appointments.class);



        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;

    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null)
            sessionFactory = createSessionFactory();

        return sessionFactory;
    }
}
