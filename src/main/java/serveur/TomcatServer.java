package serveur;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class TomcatServer implements AppServer{


    private Tomcat tomcat;
    private static String dir = "src/main/webapp/";
    private final int PORT = 8081;

    @Override
    public void create() {
        String serverport = System.getenv("server.port");
        tomcat = new Tomcat();
        tomcat.setPort(PORT);
    }

    @Override
    public void configure() throws ServletException {
        tomcat.getConnector();

        Context context = tomcat.addWebapp("", new File(dir).getAbsolutePath());
        File classDir = new File("out/production/classes");
        WebResourceRoot resourceRoot = new StandardRoot(context);

        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes", classDir.getAbsolutePath(), "/"));

        context.setResources(resourceRoot);
    }

    @Override
    public void start() throws LifecycleException {
        tomcat.start();
        tomcat.getServer().await();
    }

    @Override
    public void stop() throws LifecycleException {
        tomcat.stop();
    }
}
