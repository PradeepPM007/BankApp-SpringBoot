package application.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.bll.AccountManager;
import application.bll.CustomerManager;
import application.bll.UserManager;
import application.entity.Account;
import application.entity.Customer;
import application.entity.User;

@Controller
@RequestMapping("/view")
public class ViewController {

	 @Autowired
	    private CustomerManager customerManager;
	    
	    @Autowired
	    private UserManager userManager;
	    
	    @Autowired
	    private AccountManager accountManager;
	
	  @RequestMapping(value = "/viewCustomer",method = RequestMethod.GET)
	    public String viewCustomer(HttpServletRequest request, Model model) {
	    	User activeUser = userManager.findByUsername(request.getRemoteUser());
	    	List<Customer> list = customerManager.findCustomerByUser(activeUser);
	        model.addAttribute("customer", list);
	        return "/viewCustomer";
	    }
	  
	  @RequestMapping(value = "/viewAccount",method = RequestMethod.GET)
	    public String viewAccount(HttpServletRequest request, Model model) {
	    	User activeUser = userManager.findByUsername(request.getRemoteUser());
	    	List<Account> list = accountManager.findAccountByUser(activeUser);
	        model.addAttribute("account", list);
	        return "customerOp/viewAccount";
	    }
}