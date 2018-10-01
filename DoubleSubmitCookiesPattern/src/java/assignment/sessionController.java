/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Random;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class sessionController {

    private HttpSession session;
    private static String csrfToken;

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
    }

    public static String getCsrfToken() {
        return csrfToken;
    }
}
