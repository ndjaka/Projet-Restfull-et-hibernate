package serveur;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public interface AppServer {
    void create();
    void configure() throws ServletException;
    void start() throws LifecycleException;
    void stop() throws LifecycleException;
}
