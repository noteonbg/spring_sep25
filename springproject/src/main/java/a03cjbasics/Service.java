package a03cjbasics;

public class Service {
	
	private DAOInterface d;

	public void setD(DAOInterface d) {
		this.d = d;
	}

	public void someServiceFunction() {
		// TODO Auto-generated method stub
		System.out.println("this is service layer");
		d.daoFunctionViaInterface();
		System.out.println("End of service layer telling presentation what happened");
		
	}
	
	
	
	

}
