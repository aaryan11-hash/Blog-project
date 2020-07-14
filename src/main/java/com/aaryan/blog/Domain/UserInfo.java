package com.aaryan.blog.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;



@Entity
@Table(name="user_info")
public class UserInfo implements Comparable<UserInfo> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name="username")
	@Pattern(regexp ="^[a-zA-Z0-9@_]{2,15}",message="message can only contain small or All caps and only numbers!!")
	private String username;
	
	@Column(name="password")
	@Pattern(regexp ="^[a-zA-Z0-9@_]{2,15}",message="message can only contain small or All caps and only numbers!!")
	private String password;
	
	@Column(name="firstname")
	@Pattern(regexp="[a-zA-Z]{3,20}",message="name can only consist of letters!!")
	private String firstname;
	
	@Column(name="lastname")
	@Pattern(regexp="[a-zA-Z]{3,20}",message="name can only consist of letters!!")
	private String lastname;
	
	@Column(name="education")
	private String education;
	
	@Column(name="age")
	@Min(value = 13,message="age limit is 13 and higher!!!")
	@Positive(message = "value has to be positive")
	private int age;
	
	@Column(name="preferredgenre")
	private String [] prefferedGenre;
	
	
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Blogs> blogsList;


	
	public void addBlogs(Blogs blogs) {
		if(blogsList==null)
			blogsList=new ArrayList<>();
		
		blogsList.add(blogs);
		blogs.setUserinfo(this);
		
	}
	
	
	
	
	
	
	public UserInfo(int usefulid, String username, String password, String firstname, String lastname, String education,
			int age, String [] prefferedGenre, List<Blogs> blogsList) {
		
		
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.education = education;
		this.age = age;
		this.prefferedGenre = prefferedGenre;
		this.blogsList = blogsList;
	}

	
	public UserInfo(String username,String password) {
		this.username=username;
		this.password=password;
	}



	public UserInfo() {
		
	}






	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String[] getPrefferedGenre() {
		return prefferedGenre;
	}

	public void setPrefferedGenre(String []prefferedGenre) {
		this.prefferedGenre = prefferedGenre;
	}

	public List<Blogs> getBlogsList() {
		return blogsList;
	}


	public void setBlogsList(List<Blogs> blogsList) {
		this.blogsList = blogsList;
	}

	
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", education=" + education + ", age=" + age + ", prefferedGenre="
				+ prefferedGenre + "]";
	}




	@Override
	public boolean equals(Object o) {
		if(this==o)
			return true;
		
		if((o==null) || o.getClass()!=this.getClass())
			return false;
		
		String username=((UserInfo)o).getUsername();
		return this.username.equals(username);
		
	}

	
	@Override
	public int hashCode() {
		
		return this.username.hashCode()+57;
	}




	@Override
	public int compareTo(UserInfo o) {
		if(this.id>o.getId())
			return 1;
		else 
			return -1;
		
	}
	
	
	
	
	

}
