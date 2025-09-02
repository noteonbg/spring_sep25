package bank;

import bank.model.Bank;
import bank.model.BankStatus;
import bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApp implements CommandLineRunner {

    public static void main(String[] args)
    {

    //    SpringApplication.run(BankApp.class,args);


        SpringApplication springApplication =new SpringApplication(BankApp.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

    @Autowired  //Dependancy injection
    private BankService bankService;

    @Override
    public void run(String... args) throws Exception {

        Bank bank =new Bank(10,"no","inagar","blore",23);
        BankStatus bankStatus = bankService.addBank(bank);
        if(bankStatus.getStatusCode() == 1)
            System.out.println("pleasure line by programmer ok added");
        else if(bankStatus.getStatusCode() == 0)
            System.out.println("bank id aready taken");
        else
            System.out.println("system is busy..");

    }
}
