package com.aaryan.blog.Service;

import java.util.List;


import com.aaryan.blog.Domain.Blogs;
import com.aaryan.blog.Domain.UserInfo;
import com.aaryan.blog.Repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Component
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepo blogdao;
	
	@Override

	public List<UserInfo> getUserList(){
		
		return blogdao.getUserList();
	}
	
	@Override

	public UserInfo getUserBlogs(int id){
		
		return blogdao.getUserBlogs(id);
	}

	@Override

	public void saveUser(UserInfo user) {

		blogdao.saveUser(user);
	}

	@Override
	public void saveBlog(Blogs blog, int id) {
		blogdao.saveBlog(blog,id);
	}

	@Override
	public List<Blogs> getUserBlogsOnly(int id) {
		return blogdao.getUserBlogsOnly(id);
	}


}
