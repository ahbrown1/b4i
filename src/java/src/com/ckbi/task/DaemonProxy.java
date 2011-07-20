package com.ckbi.task;



import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

// Creates and wraps a working daemon in a proxy interface.
// Allows the Daemon application to be programmed by Spring
// instead of directly invoking in jsvc.
public class DaemonProxy implements Daemon {

	protected static final String SP_CFG = "applicationContext.xml";
	private static Logger  log = Logger.getLogger("DaemonProxy");
	
	private Daemon daemon ;
	
	protected static final String DAEMON_BEAN_KEY = "daemon" ;
	protected static final String DFLT_DAEMON_BEAN_NAME = "daemon" ;
	
	public void setDaemon(Daemon daemon) {
		this.daemon = daemon;
	}

	@Override
	public void destroy() {
		log.info("destroy invoked");
		daemon.destroy() ;
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		log.info("init invoked");
		BeanFactory factory = new XmlBeanFactory(
				new ClassPathResource(SP_CFG));
		String daemonBean = System.getProperty(DAEMON_BEAN_KEY, DFLT_DAEMON_BEAN_NAME) ;
		daemon = (Daemon)factory.getBean(daemonBean);
		daemon.init(arg0) ;
	}

	@Override
	public void start() throws Exception {
		log.info("start invoked");
		daemon.start();
	}

	@Override
	public void stop() throws Exception {
		log.info("stop invoked");
		daemon.stop();
	}

}
