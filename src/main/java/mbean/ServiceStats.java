package mbean;

import java.beans.ConstructorProperties;

public class ServiceStats {

	private int liczba;
	
	
	public int getLiczba() {
		return liczba;
	}
	public void setLevel(int liczba) {
		this.liczba = liczba;
	}
	
	public ServiceStats() {
		super();
	}
	
	@ConstructorProperties({"liczba"}) 
	public ServiceStats(int liczba) {
		super();
		this.liczba = liczba;
		
	} 

}
