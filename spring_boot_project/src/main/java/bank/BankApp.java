package bank;

import bank.dao.BankRepository;
import bank.model.Bank;
import bank.model.BankStatus;
import bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BankApp// implements CommandLineRunner
 {

    public static void main(String[] args)
    {



        SpringApplication springApplication =new SpringApplication(BankApp.class);
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

      //Dependancy injection

     @Autowired
    private BankService bankService;

    private BankRepository bankRepository;

        public void run(String... args) throws Exception {

            Bank updatedBank =new
                    Bank(1,"A","newadd","newheadoffice",3);
            BankStatus bankStatus = bankService.updateBank(updatedBank);
            System.out.println(bankStatus.getStatusCode());



            /*String abc ="mum";
            List<Bank> banks = bankRepository.findByheadoffice(abc);
            for(Bank b: banks)
            {
                System.out.println(b.getBankId());

            }
*/



/*
            int bankId =1;
            String banknewAdress="x";
            String headQrs ="y";
            Bank updatedBank = new Bank(bankId,"",banknewAdress,headQrs,3);

*/



         }
}
