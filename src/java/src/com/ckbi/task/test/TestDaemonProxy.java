package com.ckbi.task.test;

import static org.junit.Assert.*;

import org.apache.commons.daemon.DaemonInitException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ckbi.task.DaemonProxy;

public class TestDaemonProxy {

	private static DaemonProxy task ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		task = new DaemonProxy() ;
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testInit() {
		try {
			task.init(null);
		} catch (DaemonInitException e) {
			e.printStackTrace();
			fail("DaemonInitException");
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
		
	}

	@Test
	public void testStart() {
		try {
			task.start();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
	}

	@Test
	public void testStop() {
		try {
			task.stop();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception");
		}
	}
	@Test
	public void testDestroy() {
		task.destroy();
	}


}
