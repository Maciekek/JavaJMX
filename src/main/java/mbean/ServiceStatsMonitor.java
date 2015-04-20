package mbean;

import com.example.restservicedemo.service.Counter;
import com.example.restservicedemo.service.SiteManager;

public class ServiceStatsMonitor implements IServiceStatsMonitor {
	
	private SiteManager sm;
	
	public ServiceStatsMonitor(SiteManager sm) {
		this.sm = sm;
	}

	@Override
	public ServiceStats getServiceStats() {
		return new ServiceStats(Counter.number);
	}


}
