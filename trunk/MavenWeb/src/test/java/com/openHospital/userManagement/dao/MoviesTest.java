package com.openHospital.userManagement.dao;

import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.apache.tomee.embedded.EmbeddedTomEEContainer;
import org.junit.Test;

import com.openHopital.userManagement.dao.AuthoritiesDao;
import com.openHopital.userManagement.entity.Authorities;

/**
 * @version $Revision: 607077 $ $Date: 2007-12-27 06:55:23 -0800 (Thu, 27 Dec 2007) $
 */
public class MoviesTest{

	@Test
    public void test() throws Exception {
		
		
		final Properties p = new Properties();
        p.put("MavenWebDatabase", "new://Resource?type=DataSource");      
        p.put("MavenWebDatabase.JdbcDriver", "oracle.jdbc.OracleDriver");
        p.put("MavenWebDatabase.JdbcUrl", "jdbc:oracle:thin:@10.203.62.82:1521:xe;user=test;password=test;");
        //p.put("MavenWebDatabase.user", "test");
       //p.put("MavenWebDatabase.password", "test");

        final Context context = EJBContainer.createEJBContainer(p).getContext();
		//Properties p = new Properties(); 
        //p.setProperty(EJBContainer.APP_NAME, "simple-security"); 
        //p.setProperty(EJBContainer.PROVIDER, "tomee-embedded"); // need web feature 
       
       // p.setProperty(EmbeddedTomEEContainer.TOMEE_EJBCONTAINER_HTTP_PORT, "9999"); 
       // final Context context = EJBContainer.createEJBContainer(p).getContext();
       
		// final Context context = EJBContainer.createEJBContainer().getContext();
	        //Movies movies = (Movies) context.lookup("java:global/jpa-hibernate/Movies");
		
		AuthoritiesDao authoritiesDao = (AuthoritiesDao) context.lookup("java:global/MavenWeb/AuthoritiesDaoImpl");

        
        Authorities authorities = new Authorities();
		authorities.setAuthority("authority");
		
		authoritiesDao.find("authority");

        
    }
}
