package com.example.restservicedemo.service;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import mbean.ServiceMonitor;

@Path("site")
public class SiteManager  {
	public static ServiceMonitor sm;
	
	
	@GET
	@Path("/test")
	@Produces("application/json")
	public String test() throws Exception{
		sm = new ServiceMonitor();
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
		ObjectName monitorName = new ObjectName("com.example.jvmint:type=Server,name=SomeService");
		mbs.registerMBean(sm, monitorName);
		
		while(true){
			//System.out.println("Działam");
			Thread.sleep(10);
		}
	}

	@GET
	@Path("/change")
	@Produces("application/json")
	public String change(){

		sm.setNumber(100);
		return  Counter.number+ "";
	}
	
	@GET
	@Path("/check")
	@Produces("application/json")
	public String check(){
		
		return Counter.number + "";
	}
}
