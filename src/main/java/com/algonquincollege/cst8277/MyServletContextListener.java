/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: MyServletContextListener.java
 * Course materials (19F) CST 8277
 * @author (original) Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
package com.algonquincollege.cst8277;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Programatically replace web.xml setup with this
 * {@link ServletContextListener} NB: some web.xml elements cannot be
 * programatically replaced, for example &lt;welcome-file-list&gt;
 * 
 * @author mwnorman
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ServletContext sc = sce.getServletContext();
        sc.log("MyServletContextListener - contextInitialized");
        sc.setInitParameter("jersey.config.jsonFeature", "JacksonFeature");
    }
}