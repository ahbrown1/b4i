package com.ckbi.task;



import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.log4j.Logger;

// Wraps a working daemon in a proxy interface.
// Allows the Daemon application to be programmed by Spring
// instead of directly invoking in jsvc.
public class TestDaemon implements Daemon {

	private static Logger  log = Logger.getLogger("TestDaemon");
	
	
	@Override
	public void destroy() {
		log.info("destroy invoked");
		
	}

	@Override
	public void init(DaemonContext arg0) throws DaemonInitException, Exception {
		log.info("init invoked");
	
	}

	@Override
	public void start() throws Exception {
		log.info("start invoked");
		
	}

	@Override
	public void stop() throws Exception {
		log.info("stop invoked");

	}

}
