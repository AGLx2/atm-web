package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {
    private BankAccountService service;

    public BankAccountController(BankAccountService service) {
        this.service = service;
    }

    @GetMapping
    public String getCustomerPage(Model model) {
        model.addAttribute("allBankaccounts", service.getBankAccounts());
        return "bankaccount";
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute BankAccount bankAccount, Model model) {
        service.createBankAccount(bankAccount);
        model.addAttribute("allBankaccounts", service.getBankAccounts());
        return "redirect:bankaccount";
    }
}
