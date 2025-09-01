package a01archcode;

import java.util.List;


//pain part in  a project..

public interface ServiceInf {

	boolean registerUser(CUser user);

	CUser getUserDetails(String userid);
	//Hey look at pincoe of user object if it is zero, then assume your userid is not found.
	

	boolean updateUserDetails(CUser user);

	boolean removeUser(String userid);

	List<CUser> getUsersBasedOnPincode(int pincode);

}
