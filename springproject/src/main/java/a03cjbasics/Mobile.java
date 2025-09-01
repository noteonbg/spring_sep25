package a03cjbasics;

public class Mobile {
	
	private Sim s;
	private Battery b;
	
	public Mobile()
	{
		System.out.println("Mobile created");
		b =new Battery();
		b.setMah(4000);
	}
	
	public void setSim(Sim y)
	{
		s = y;
		
	}

	public void makeCall() {
		// TODO Auto-generated method stub
		System.out.println("making call" + s.getSimno() + " --" + b.getMah());
		
	}
	
	
	public void sendSMS()
	{
		System.out.println("senidng sms" + s.getSimno() + " --" + b.getMah());
		
		
		
	}
	

}
