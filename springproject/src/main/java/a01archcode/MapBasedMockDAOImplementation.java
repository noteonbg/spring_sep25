package a01archcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapBasedMockDAOImplementation implements DAOInterface {
	
	private Map<String,CUser> users ;
	
	public MapBasedMockDAOImplementation()
	{
		
		users=new HashMap<>();
		CUser user =new CUser("A","B","C",400044);
		users.put(user.getUsername(), user);
		user =new CUser("D","E","F",400044); //why are we writing user = and not Cuser user = ?
		users.put(user.getUsername(), user);
		user =new CUser("G","G","I",400045);		
		users.put(user.getUsername(), user);
		
		
		
	}

	@Override
	public void registerUserInDb(CUser user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		user = users.get(user.getUsername());
		if (user != null)//if key is present, that means it is a duplicate userid.
		{  
			throw new DuplicateUserException("duplicate User found");
			
		}
		users.put(user.getUsername(),user);
		
		
	}

	@Override
	public CUser getUserDetailsFromDb(String userid) {
		// TODO Auto-generated method stub
		
		CUser userToFind = null;//think why we did not pass other parameters.
		userToFind = users.get(userid);
		if (userToFind == null)
		{  
			userToFind = new CUser(userid,"","",0);
		}
		return userToFind;
	}
	
	
	
	
	

	@Override
	public boolean updateDetailsInDb(CUser user) {
		// TODO Auto-generated method stub
		
		//Cuser object is mutable.
		
		boolean updatedStatus = false;
		CUser cUser = users.get(user.getUsername()); //think why we created a new reference cUser here
		//and not used user = users.get(user.getUsername()
		
		if(cUser != null)
		{
			//think why are we doing this.
			cUser.setEmail(user.getEmail());
			cUser.setPassword(user.getPassword());
			cUser.setPincode(user.getPincode());
			updatedStatus = true;
			
		}
		return updatedStatus;
	}

	@Override
	public boolean removeUserInDb(String userid) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		CUser cUser = users.remove(userid); //think why we created a new reference cUser here
		//and not used user = users.get(user.getUsername()
		
		if(cUser != null)
		{
				deleted = true;
		
		}
		return deleted;
	}

	@Override
	public List<CUser> getAllUsersFromDBBasedonPincode(int pincode) {
		// TODO Auto-generated method stub
		List<CUser> cusers = new ArrayList<>();
		for(CUser user: users.values())  //find out what is return type of user.values functions
		{
			if(user.getPincode() == pincode) //think why == was used and not .equals.
			{
				cusers.add(user);
			}
			
		}
		
		return cusers;
	}
	
	
	

}
