package a03cjbasics;

public class Presentation {
	
	private Service service;
	
	public Presentation()
	{
		System.out.println("presnetation created");
	}

	public void setService(Service service) {
		System.out.println("service wired into presentation");
		this.service = service;
	}
	
	public void startTheApp()
	{
		System.out.println("got input from user");
		service.someServiceFunction();
		System.out.println("Based on service update ui");
		
	}
	
	
	
}
