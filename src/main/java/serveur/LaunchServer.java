package serveur;

import serveur.AppServer;
import serveur.TomcatServer;

public class LaunchServer {
    public static void main(String[] args) throws Exception {
        AppServer appServer = new TomcatServer();
        appServer.create();
        appServer.configure();
        appServer.start();
    }
}
