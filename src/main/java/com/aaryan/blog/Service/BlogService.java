package com.aaryan.blog.Service;

import java.util.List;

import com.aaryan.blog.Domain.*;

public interface BlogService {

	List<UserInfo> getUserList();

	UserInfo getUserBlogs(int id);

	void saveUser(UserInfo user);

    void saveBlog(Blogs blog, int id);

	List<Blogs> getUserBlogsOnly(int id);
}
