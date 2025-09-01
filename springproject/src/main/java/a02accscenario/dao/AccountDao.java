package a02accscenario.dao;

import a02accscenario.model.AccountStatus;

public interface AccountDao {

	AccountStatus getAccountDetailsFromDB(int accountno, int pin);

}
