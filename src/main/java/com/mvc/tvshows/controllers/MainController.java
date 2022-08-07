package com.mvc.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.tvshows.models.Rating;
import com.mvc.tvshows.models.Show;
import com.mvc.tvshows.models.User;
import com.mvc.tvshows.models.UserLogin;
import com.mvc.tvshows.services.RatingService;
import com.mvc.tvshows.services.ShowService;
import com.mvc.tvshows.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	ShowService showService;
	
	@Autowired 
	RatingService ratingService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/register";
	}
	
	@GetMapping("/index")
	public String mainPage() {
		return "index.jsp";
	}
	// user registration
	
	@GetMapping("/register")
	public String index(Model model) {
		 model.addAttribute("newUser", new User());
		 model.addAttribute("newLogin", new UserLogin());
		 return "index.jsp";
		}
	@PostMapping("/register")
	public String authentication(@Valid @ModelAttribute("newUser") 
			User newUser, BindingResult result, Model model, HttpSession session) {
		System.out.println(result);
		User user = userService.register(newUser, result);
	    if(result.hasErrors()) {
	        // Be sure to send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new UserLogin());
	        return "index.jsp";
	    }
	    
	    session.setAttribute("userId", newUser);
		return "redirect:/dashboard";
		}
	
	// user dashboard
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("shows") Show show, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("shows", showService.all());
		System.out.println(showService.all()); //test to see if shows are retrieved
		return "dashboard.jsp";
	}
	
	@GetMapping("/shows/{id}")
	public String shows(@PathVariable("id")Long id, Model model, @ModelAttribute("user") User user,
			@ModelAttribute("ratings") Rating rating,@ModelAttribute("shows") 
	Show show, HttpSession session){
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("shows", showService.findBy(id));
		model.addAttribute("ratings", ratingService.all());
		System.out.println(id); // test to make sure the correct show id is being retrieved
		return "show.jsp";
	}
	
	// add new show
	@GetMapping("/create")
	public String newshow(@ModelAttribute("shows") Show sow, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		return "create.jsp";
	}
		
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("shows") Show show, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("show", showService.all());
			System.out.println("Error present!");
			return "create.jsp";
		}
		model.addAttribute("show", showService.all());
		this.showService.save(show);
		return "redirect:/dashboard";
	}
	
	// edit show entry
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long id, Model model, HttpSession session) {
		Show show = showService.findBy(id);
    	model.addAttribute("shows", show);
		return "update.jsp";
	}
	@PostMapping("/edit/{id}")
	public String editShow(@PathVariable("id")Long id,@Valid @ModelAttribute("shows") Show show, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("show", showService.all());
			System.out.println("Error present!");
			return "update.jsp";
		}
		model.addAttribute("show", showService.all());
		this.showService.save(show);
		return "redirect:/dashboard";
	}
	
	// delete show
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, @ModelAttribute("shows") Show show, Model model, HttpSession session) {
		model.addAttribute("show", showService.all());
		this.showService.delete(show);
		return "redirect:/dashboard";
	}
	// user login and logout
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") UserLogin newLogin, BindingResult result, Model model, HttpSession session) {
	     
		User user = userService.login(newLogin, result);
	 
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	    
	    session.setAttribute("userId", user);
	    System.out.println(user.getEmail()); 
	    return "redirect:/dashboard";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 session.setAttribute("userId", null);
	     return "redirect:/";
	}
}
