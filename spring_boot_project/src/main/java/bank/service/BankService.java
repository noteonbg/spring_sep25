package bank.service;

import bank.dao.BankRepository;
import bank.model.Bank;
import bank.model.BankStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public BankService() {
        System.out.println("Bank service created");
    }

    public BankStatus addBank(Bank bankInfo) {
        BankStatus bankStatus =
                new BankStatus(-1, "system not working", bankInfo);
        if (bankRepository.existsById(bankInfo.getBankId())) {
            bankStatus.setStatusCode(0);
            bankStatus.setMessage("bank id is already taken");
            bankStatus.setBankinfo(bankInfo);


        } else {
            bankRepository.save(bankInfo);
            bankStatus.setStatusCode(1);
            bankStatus.setMessage("added bank");
            bankStatus.setBankinfo(bankInfo);


        }
        return bankStatus;
    }

    public BankStatus updateBank(Bank updatedBank)
    {

        BankStatus bankStatus =
                new BankStatus(-1, "system not working", updatedBank);
        Optional<Bank> box = bankRepository.findById(updatedBank.getBankId());
        if(box.isEmpty())
        {
            bankStatus.setStatusCode(0);
            bankStatus.setMessage("bank id is not found");
            bankStatus.setBankinfo(updatedBank);
        }
        else
        {
            Bank fromdb = box.get();
            fromdb.setAddress(updatedBank.getAddress());
            fromdb.setHeadoffice(updatedBank.getHeadoffice());
            bankRepository.save(fromdb);// confirm the update..
            bankStatus.setStatusCode(1);
            bankStatus.setMessage("bankdetails updated");
            bankStatus.setBankinfo(updatedBank);
        }

       return bankStatus;
    }











}
