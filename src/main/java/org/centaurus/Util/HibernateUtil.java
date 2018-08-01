package org.centaurus.Util;

import org.centaurus.app.config.HibernateConfig;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtil {
    HibernateConfig config = new HibernateConfig();

    @Bean
    SessionFactory sessionFactory(){
        return config.getSessionFactory();
    }
}
