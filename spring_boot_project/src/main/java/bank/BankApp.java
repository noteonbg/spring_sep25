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

import java.util.Optional;

@SpringBootApplication
public class BankApp implements CommandLineRunner
 {

    public static void main(String[] args)
    {



        SpringApplication springApplication =new SpringApplication(BankApp.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

      //Dependancy injection


    //private BankService bankService;
    @Autowired
    private BankRepository bankRepository;

        public void run(String... args) throws Exception {

            int bankId =1;
            String banknewAdress="x";
            String headQrs ="y";
            Bank updatedBank = new Bank(bankId,"",banknewAdress,headQrs,3);
            Optional<Bank> box = bankRepository.findById(bankId);
            if(box.isEmpty())
            {
                System.out.println("ok id not found");
            }
            else
            {
                Bank fromdb = box.get();
                fromdb.setAddress(updatedBank.getAddress());
                fromdb.setHeadoffice(updatedBank.getHeadoffice());
                bankRepository.save(fromdb);// confirm the update..
                System.out.println("bank update succssful");


            }




         }
}
