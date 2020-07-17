package com.aaryan.blog.Repository;

import com.aaryan.blog.Domain.Blogs;
import com.aaryan.blog.Domain.UserInfo;

import java.util.List;



public interface BlogRepo {

	List<UserInfo> getUserList();

	UserInfo getUserBlogs(int id);

	void saveUser(UserInfo user);

	void saveBlog(Blogs blog, int id);
	List<Blogs> getUserBlogsOnly(int id);
}
