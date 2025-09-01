package a01archcode;

import java.util.ArrayList;
import java.util.List;

public class ListBasedMockDAOImplementation implements DAOInterface {
	
	private List<CUser> users ;
	
	public ListBasedMockDAOImplementation()
	{
		
		users=new ArrayList<>();
		users.add(new CUser("A","B","C",400044));
		users.add(new CUser("D","E","F",400044));
		users.add(new CUser("G","G","I",400045));
		
	}

	@Override
	public void registerUserInDb(CUser user) throws DuplicateUserException {
		// TODO Auto-generated method stub
		int position = users.indexOf(user);
		if (position != -1)
		{  
			throw new DuplicateUserException("duplicate User found");
			
		}
		users.add(user);
		
	}

	@Override
	public CUser getUserDetailsFromDb(String userid) {
		// TODO Auto-generated method stub
		
		CUser userToFind = new CUser(userid,"","",0);//think why we did not pass other parameters.
		int pos = users.indexOf(userToFind);
		if(pos != -1)
		{
			userToFind = users.get(pos);
			
		}
		return userToFind;
	}

	@Override
	public boolean updateDetailsInDb(CUser user) {
		// TODO Auto-generated method stub
		
		boolean updatedStatus = false;
		int pos = users.indexOf(user);
		if(pos != -1)
		{
			//think why are we doing this.
			CUser userFromList = users.get(pos);
			user.setEmail(user.getEmail());
			user.setPassword(user.getPassword());
			user.setPincode(user.getPincode());
			updatedStatus = true;
				
		}
		
		return updatedStatus;
	}

	@Override
	public boolean removeUserInDb(String userid) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		CUser userToFind = new CUser(userid,"","",0);//think why we did not pass other parameters.
		int pos = users.indexOf(userToFind);
		if(pos != -1)
		{
			users.remove(pos);
			deleted  =true;
			
		}
		return deleted;
	}

	@Override
	public List<CUser> getAllUsersFromDBBasedonPincode(int pincode) {
		// TODO Auto-generated method stub
		List<CUser> cusers =new ArrayList<CUser>(); //if i change the refernce to users what will happen think
		for(CUser user: users)
		{
			if(user.getPincode() == pincode) //think why == was used and not .equals.
			{
				cusers.add(user);
			}
			
		}
		
		return cusers;
	}
	
	
	

}
