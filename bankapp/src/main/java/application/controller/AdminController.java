package application.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import application.bll.CustomerManager;
import application.bll.RoleManager;
import application.bll.UserManager;
import application.entity.Customer;
import application.entity.Role;
import application.entity.User;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerManager customerManager;
    
    @Autowired
    private RoleManager roleManager;
    
    @Autowired
    private UserManager userManager;
 

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newClient() {
        return "admin/newCustomer";
    }

    @RequestMapping(value = "/newCustomer",method = RequestMethod.POST)
    public String addCustomer(HttpServletRequest request) {
    	try {
    		Role role = roleManager.findByRole(request.getParameter("role"));
        	User user = (User) customerManager.createNewTransientDomain(User.class.getName());
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
        	user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        	userManager.executeSaveUser(user);
        	
        	Customer customer = (Customer) customerManager.createNewTransientDomain(Customer.class.getName());
        	customer.setName(request.getParameter("name"));
        	customer.setApplicationId(request.getParameter("applicationId"));
        	customer.setAddress(request.getParameter("address"));
        	customer.setEmail(request.getParameter("email"));
        	customer.setStatus(request.getParameter("status"));
        	customer.setUsername(user);
        	customerManager.executeSaveCustomer(customer);
    	}
    	catch (Exception e) {
    		return "redirect:/admin/new?error=true";
		}
    	
    	    	
        return "redirect:/index";
    }

    @RequestMapping(value = "/{applicationId}/editCutomer",method = RequestMethod.GET)
    public String update(@PathVariable String applicationId, Model model, HttpServletRequest request) {
        Customer customer = customerManager.findCutomerOnApplicationId(applicationId);
        model.addAttribute("customer",customer);
        return "admin/editCustomer";
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateCustomer( HttpServletRequest request) {
    	Customer customer = customerManager.findCutomerOnApplicationId(request.getParameter("applicationId"));
    	customer.setName(request.getParameter("Name"));
    	
    	
    	
    	
    	customerManager.executeUpdateCustomer(customer);
        return "redirect:/index";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String displaySearch(){
        return "admin/searchCustomer";
    }
    @RequestMapping(value = "/searchCustomer",method = RequestMethod.POST)
    public String search(HttpServletRequest request) {
       
    	String applicationId = request.getParameter("applicationId");
    	String option = request.getParameter("option");
    	if(option.equals("DELETE")) {
            return "redirect:/admin/" + applicationId + "/deleteCutomer";
        }
        if(option.equals("EDIT")) {
            return "redirect:/admin/" + applicationId + "/editCutomer";
        }
        return "redirect:/clientOp/search";
    }
    
    @RequestMapping(value = "/{applicationId}/deleteCutomer",method = RequestMethod.GET)
    public String delete(@PathVariable String applicationId) {
    	customerManager.executeDeleteByApplicationId(applicationId);
        return "redirect:/index";
    }
}
