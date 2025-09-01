package a01archcode;

import java.util.List;

public class Presentation {
	
	private ServiceInf serviceInf;
	
	
	public Presentation() {
		serviceInf = new ServiceImplementation();//what is relationship between Presentation and ServiceInf
	}




	public void startTheApp() {
		// TODO Auto-generated method stub
		
		
		//dont run all teh functions at once. run one function at a time and understand the whole code..
		
	//	insertLogic();
		
		 singleSelectAndUpdateLogic(); 
		  //deleteLogic(); 
		 // multiSelectLogic();
		 
		
		
		
		
	}




	private void multiSelectLogic() {
		// TODO Auto-generated method stub
		 serviceInf = new ServiceImplementation();
		
		int pincode =400044;
		//change pincode to 400000 and see what will result be..
		
		List<CUser> users = serviceInf.getUsersBasedOnPincode(pincode);
		StringBuilder s =new StringBuilder();
		if(users.size() ==0 )
		{
			s.append("no users found with pincode  ");
			s.append(pincode);
			System.out.println(s); //which function of STringBuilder will get called here 
			
			
		}
		else
		{
			s.append("\n userid password email pin is ");
			for(CUser cuser: users)
			{
				
				s.append("\n");
				s.append(cuser.getUsername());
				s.append(" --" );
				s.append(cuser.getPassword()).
				append(" --" ).
				append(cuser.getEmail()).
				append(" --" ).
				append(cuser.getPincode());
				//observe why line no 57,58 and 59 does have s. before it.
				
						
				
			}
			System.out.println(s);
			
		}
		
		
	}




	private void deleteLogic() {
		// TODO Auto-generated method stub
		String userid="A";
		//change userid to X and think what will be the output
		boolean deleted = serviceInf.removeUser(userid);
		if(deleted)
			System.out.println("removed userid" + userid);  //is this good or preferrable to use StringBuilder think..
		else
		{
			System.out.println("could not find userid  " + userid);
			//replace above line with string builder.
			
		}
			
		
		
	}




	private void singleSelectAndUpdateLogic() {
		// TODO Auto-generated method stub
		String userid ="A";
		CUser user = serviceInf.getUserDetails(userid);
		if(user.getPincode() ==0)
		{
			System.out.println("user details not found");
			
		}
		else
		{
			//assume user gave new details for email and pin code.
			user.setEmail("newemail");
			user.setPincode(444444);
			user.setPassword("newpass");
			boolean updated = serviceInf.updateUserDetails(user);
			if(updated)
				System.out.println("details updated");
			else
				System.out.println("details not updated"); //will this line ever get printed if yes or if no think why.
			
			
		}
		
		
	}




	private void insertLogic() {
		// TODO Auto-generated method stub
		
		//CUser user =new CUser("abc","def","def@ghi.com",400019); // uncomment this line to successful registration
		
		//comment the below line and uncomment above line for getting successful registration.
		CUser user =new CUser("A","def","def@ghi.com",400019);   
		
		boolean registeredStatus = serviceInf.registerUser(user);
		if(registeredStatus )
			System.out.println("user registered successfully");
		else
			System.out.println("user registration did not suceed");
		
	}

}
