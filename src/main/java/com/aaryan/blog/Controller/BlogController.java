package com.aaryan.blog.Controller;

import java.util.List;

import javax.validation.Valid;

import com.aaryan.blog.Helper.AuthenticationAndLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaryan.blog.Domain.*;
import com.aaryan.blog.Service.*;

@Controller
@RequestMapping("/blog")
public class BlogController {

	
	
	private int userid;

	private List<Blogs> userBlogs;

	private List<Blogs> otherBlogs;
	
	private Blogs blogRenderer;
	
	private UserInfo userinfo;
	
	private AuthenticationAndLogin helper;

	private static boolean lock=false;
	
	@Autowired
	BlogService service;
	
	public BlogController() {
		this.userinfo=new UserInfo();
	}
	
	
	@RequestMapping("/loginpage")
	public String loginpage(Model model) {
		UserInfo userinfo =new UserInfo();
		model.addAttribute("user",userinfo);
		
		return "loginPage";
	}
	
	@GetMapping("/afterlogin")
	public String verifyLogin(@ModelAttribute("user") UserInfo user,Model model) {
		int truth=helper.verifiedloginUser(service.getUserList(),user);
		System.out.println("truth value:"+truth);
		if(truth==0) {
			
			return "redirect:/blog/loginpage";
		}else {
			this.userid=truth;
			this.userinfo=service.getUserBlogs(truth);
			this.userBlogs=this.userinfo.getBlogsList();
			
			//cookie=new Cookie("username",this.userinfo.getUsername());
			//cookie.setMaxAge(60*60);
			//response.addCookie(cookie);
			
			model.addAttribute("username",userinfo.getUsername());
			model.addAttribute("user",userinfo);
			model.addAttribute("myblog",this.userBlogs);
			return "home-page";
		}
		
	
		
		
}
	
	@GetMapping("/signup")
	public String signUpUser(Model model) {
		
	
		model.addAttribute("newuser",new UserBuild());
	
		return "sign-up";
	}
	
	@GetMapping("/profileBuilder")
	public String profileBuilder(@Valid @ModelAttribute("newuser") UserBuild newuser, BindingResult result, Model model) {

		if(result.hasErrors()) {
			System.out.println("inside result error if block");

			return "sign-up";
		}

		int truth=this.helper.verifiedloginUser(service.getUserList(),new UserInfo(newuser.getUsername(),newuser.getPassword()));


			if(truth==0) {
				this.userinfo.setUsername(newuser.getUsername());
				this.userinfo.setPassword(newuser.getPassword());
				model.addAttribute("user", new UserInfo());
				model.addAttribute("username", this.userinfo.getUsername());
				return "profilebuilder";
			}

			else
				return "redirect:/blog/profileBuider";
			
		}





	@GetMapping("/postProcessing")
	public String savingNewUser(@Valid @ModelAttribute("user") UserInfo userInfo,BindingResult result,Model model){
		if(result.hasErrors()){
			return "profilebuilder";
		}
		else{
			userInfo.setUsername(this.userinfo.getUsername());
			userInfo.setPassword(this.userinfo.getPassword());
			this.userinfo=userInfo;
			service.saveUser(userinfo);
			model.addAttribute("user",this.userinfo);


			return "home-page";
		}

	}

	@GetMapping("refresh-to-home-page")
	public String backToHomePageLinkResolve(Model model){
		UserInfo user=service.getUserBlogs(this.userid);
		this.userBlogs=user.getBlogsList();

		model.addAttribute("username",userinfo.getUsername());
		model.addAttribute("user",userinfo);
		model.addAttribute("myblog",this.userBlogs);

		return "home-page";
	}
	
	
	@GetMapping("/newBlog")
	public String newBlog(Model model) {
		model.addAttribute("blog",new Blogs());
		model.addAttribute("user",this.userinfo);
		return "blogWriter";
	}

	@GetMapping("/blogchecker")
	public String blogChecker(@Valid @ModelAttribute ("blog") Blogs blog,BindingResult result){

		if(result.hasErrors())
			return "blogWriter";

		service.saveBlog(blog,this.userinfo.getId());
		return "blogWriter";
	}



	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

