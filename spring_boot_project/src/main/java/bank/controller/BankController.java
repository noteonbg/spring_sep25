package bank.controller;

import bank.model.Bank;
import bank.model.BankStatus;
import bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add")
    public ResponseEntity<BankStatus> whocares(@RequestBody Bank bank)
    {
        BankStatus bankStatus=
                new BankStatus(-1,"system not working",bank);

        ResponseEntity<BankStatus>  reponseStatus=
                new ResponseEntity<>(bankStatus, HttpStatus.INTERNAL_SERVER_ERROR);

        bankStatus=bankService.addBank(bank);

        if(bankStatus.getStatusCode() == 1)
        {
            reponseStatus=
                    new ResponseEntity<>(bankStatus, HttpStatus.CREATED);


        }

        else if(bankStatus.getStatusCode() == 0)
        {
            reponseStatus=
                    new ResponseEntity<>(bankStatus, HttpStatus.NOT_ACCEPTABLE);


        }


        return reponseStatus;

    }





    @PutMapping("/update")
    public ResponseEntity<BankStatus> nobodycares(@RequestBody Bank bank)
    {
        BankStatus bankStatus=
                new BankStatus(-1,"system not working",bank);

        ResponseEntity<BankStatus>  reponseStatus=
                new ResponseEntity<>(bankStatus, HttpStatus.INTERNAL_SERVER_ERROR);

        bankStatus=bankService.updateBank(bank);

        if(bankStatus.getStatusCode() == 1)
        {
            reponseStatus=
                    new ResponseEntity<>(bankStatus, HttpStatus.OK);


        }

        else if(bankStatus.getStatusCode() == 0)
        {
            reponseStatus=
                    new ResponseEntity<>(bankStatus, HttpStatus.NOT_ACCEPTABLE);


        }


        return reponseStatus;

    }









}
