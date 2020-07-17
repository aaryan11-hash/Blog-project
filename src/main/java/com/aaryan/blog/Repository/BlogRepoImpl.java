package com.aaryan.blog.Repository;

import java.util.ArrayList;
import java.util.List;


import com.aaryan.blog.Domain.Blogs;
import com.aaryan.blog.Domain.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Component
@Repository
public class BlogRepoImpl implements BlogRepo {


	EntityManager entityManager;

	public BlogRepoImpl(EntityManager entityManager){
		this.entityManager=entityManager;
	}


	
	@Override
	@Transactional
	public List<UserInfo> getUserList(){
		Session session=entityManager.unwrap(Session.class);
		
		
		Query<UserInfo> finallist=session.createQuery("from UserInfo",UserInfo.class);
		
		return new ArrayList<>(finallist.getResultList());
	}
	
	@Override
	@Transactional
	public UserInfo getUserBlogs(int id) {
		Session session=entityManager.unwrap(Session.class);
		
		UserInfo blogger=session.get(UserInfo.class,id);
		blogger.getBlogsList();
		
		return blogger;
	}

	@Override
	@Transactional
	public List<Blogs> getUserBlogsOnly(int id){
		Session sessi=entityManager.unwrap(Session.class);

		UserInfo user=sessi.get(UserInfo.class,id);
		return user.getBlogsList();
	}

	@Override
	@Transactional
	public void saveUser(UserInfo user){
		Session session=entityManager.unwrap(Session.class);

		session.save(user);

	}

	@Override
	@Transactional
	public void saveBlog(Blogs blog, int id) {
		Session session=entityManager.unwrap(Session.class);

		UserInfo user=session.get(UserInfo.class,id);
		user.addBlogs(blog);
		session.save(blog);
		session.save(user);
	}


}
