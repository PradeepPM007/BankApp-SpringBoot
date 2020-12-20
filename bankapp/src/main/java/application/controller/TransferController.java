package application.controller;

import application.bll.AccountManager;
import application.bll.LogManager;
import application.bll.UserManager;
import application.entity.Account;
import application.entity.Log;
import application.entity.User;
import application.validator.TransactionValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private LogManager logManager;

    @Autowired
    private UserManager userManager;

    private TransactionValidator validator;

    @RequestMapping(method = RequestMethod.GET)
    public String transfer(){
        return "transfer";
    }
//    @RequestMapping(value = "/search",method = RequestMethod.GET)
//    public String search(@RequestParam(value = "id1") long id1, @RequestParam(value = "id2") long id2, Model model) {
//        Account from = accountRepository.getOne(id1);
//        Account to = accountRepository.getOne(id2);
//        model.addAttribute("from",from);
//        model.addAttribute("to",to);
//        return "transfer/search";
//    }

    @RequestMapping(value = "process", method = RequestMethod.POST)
    public String processTransaction(HttpServletRequest request) {
        Double amount = Double.parseDouble(request.getParameter("amount"));
        Account from = accountManager.findAccountOnAccountNo(request.getParameter("id1"));
        Account to = accountManager.findAccountOnAccountNo(request.getParameter("id2"));
        if(from == null || to == null)return "redirect:/transfer?error=true";
        validator = new TransactionValidator();
        if(validator.validate(from,amount)) {
            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            accountManager.executeSave(from);
            accountManager.executeSave(to);
        }
        else
            return "redirect:/transfer?error=true";


        Log log = new Log();
        log.setOperation("Transaction: From " + from.getApplicationId() + " To " + to.getApplicationId() + " Amount " + amount);
        log.setTimestamp(new Timestamp(System.currentTimeMillis()));

        String username = request.getRemoteUser();

        User user = userManager.findByUsername(username);
        log.setUser(user);

        logManager.executeSave(log);

        return "redirect:/index";
    }

}