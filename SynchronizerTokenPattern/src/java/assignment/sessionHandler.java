package assignment;

import java.util.HashMap;
import java.util.Random;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class sessionHandler {

    private HttpSession session;
    private static String csrfToken;
    private static HashMap<String, String> hmap = new HashMap<String, String>();
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        username = user;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void generateToken() {
        String sessionId = session.getId();
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));
        csrfToken = sessionId + id;
        System.out.println("token is generated " + csrfToken);
        hmap.put(sessionId, csrfToken);
    }

    public static String getCsrfToken() {
        return csrfToken;
    }

    public static String getCsrfTokenForSession(String sessionId) {
        String token = hmap.get(sessionId);
        return token;
    }

}
