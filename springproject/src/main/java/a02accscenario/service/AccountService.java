package a02accscenario.service;

import a02accscenario.model.AccountStatus;

public interface AccountService {

	AccountStatus getBalance(int accountno, int pin);

}
