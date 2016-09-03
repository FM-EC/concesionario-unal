/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic.sessionManagement;

import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

/**
 *
 * @author monica
 */
public class SessionListener implements HttpSessionIdListener {

    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent event) {

        System.out.println("Current Session created : "
                + event.getSession().getId() + " at " + new Date());

    }

    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sessionDestroyed(HttpSessionEvent event) {

        HttpSession session = event.getSession();

        System.out.println("Current Session destroyed :"
                + session.getId() + " Logging out user...");
    }

}
