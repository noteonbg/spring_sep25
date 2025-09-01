package a01archcode;

import java.util.List;

public interface DAOInterface {

	// service layer will supply the Cuser object
	void registerUserInDb(CUser user) throws DuplicateUserException;

	//DAO class will create teh Cuser objet and return to service
	CUser getUserDetailsFromDb(String userid);

	boolean updateDetailsInDb(CUser user);

	boolean removeUserInDb(String userid);

	List<CUser> getAllUsersFromDBBasedonPincode(int pincode);

}
