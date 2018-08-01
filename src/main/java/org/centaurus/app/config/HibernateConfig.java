package org.centaurus.app.config;


import org.centaurus.entities.Categorie;
import org.centaurus.entities.Produit;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private SessionFactory sessionFactory;
    public HibernateConfig(){
        configure();
        createSessionFactory();
    }


    private Configuration configure() {
        Configuration configuration = new Configuration();
        configuration
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/boutique")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "")
               /* .setProperty("hibernate.show_sql","true")*/
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(Categorie.class)
                .addAnnotatedClass(Produit.class);



      /*  configuration
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:./enter;INIT=CREATE SCHEMA IF NOT EXISTS enter")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .setProperty("hibernate.default_schema", "enter")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "")
                .addAnnotatedClass(User.class);*/
        return configuration;
    }

    private SessionFactory createSessionFactory(){
        sessionFactory = configure().buildSessionFactory();
        return sessionFactory;
    }


    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
