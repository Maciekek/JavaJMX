package mbean;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import com.example.restservicedemo.service.Counter;
import com.example.restservicedemo.service.SiteManager;

public class ServiceMonitor extends NotificationBroadcasterSupport implements
		ServiceMonitorMBean {

//	private SomeService ss;

	private int sequenceNumber = 0;

	@Override
	public void setNumber(int liczba) {
		Counter.number = liczba;

		if (liczba > 11) {
			Notification notification = new AttributeChangeNotification(this,
					sequenceNumber++, System.currentTimeMillis(),
					"Przekroczenie poziomu", "level", "int", Counter.number,
					liczba);
			notification.setUserData("zmiana levelu  na " + liczba);
			sendNotification(notification);

		}
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };

		String name = AttributeChangeNotification.class.getName();
		String description = "Zmiana wartosci atrybutu";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name,
				description);
		return new MBeanNotificationInfo[] { info };
	}

	
	@Override
	public int getNumber() {
		return Counter.number;
	}

	@Override
	public void clear() {
		Counter.number = 0;	
	}

}
