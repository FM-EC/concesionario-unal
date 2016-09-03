/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic.sessionManagement;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author monica
 */
public class SessionTimeoutFilter implements Filter {

    private String timeoutPage = "login";

    public void init(FilterConfig filterConfig) throws ServletException {
        //We will not process anything in init method so we can omit this part too.
    }



    //Triggers for every faces-servlet request
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if ((request instanceof HttpServletRequest) && (response instanceof HttpServletResponse)) {

            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            // is session expire control required for this request? 
            if (isSessionControlRequiredForThisResource(httpServletRequest)) {
                // is session invalid? 
                if (isSessionInvalid(httpServletRequest)) {
                    String timeoutUrl = httpServletRequest.getContextPath() + "/" + getTimeoutPage();
                    System.out.println("Session is invalid! redirecting to timeoutpage : " + timeoutUrl);
                    httpServletResponse.sendRedirect(timeoutUrl);
                    return;

                }

            }
            filterChain.doFilter(request, response);
        }

    }

    private boolean isSessionControlRequiredForThisResource(HttpServletRequest httpServletRequest) {
        String requestPath = httpServletRequest.getRequestURI();
        boolean controlRequired = !requestPath.contains(getTimeoutPage());
        return controlRequired;
    }

    private boolean isSessionInvalid(HttpServletRequest httpServletRequest) {
        boolean sessionInValid = (httpServletRequest.getRequestedSessionId() != null)
                && !httpServletRequest.isRequestedSessionIdValid();
        return sessionInValid;
    }

    private String getTimeoutPage() {
        return timeoutPage;
    }

    public void setTimeoutPage(String timeoutPage) {
        this.timeoutPage = timeoutPage;
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
