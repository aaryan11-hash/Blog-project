package com.aaryan.blog.Helper;

import java.util.Collections;
import java.util.List;

import com.aaryan.blog.Domain.UserBuild;
import com.aaryan.blog.Domain.UserInfo;

public class AuthenticationAndLogin {

	public static int verifiedloginUser(List<UserInfo> userList,UserInfo user) {

			for(UserInfo u:userList) {
				if(user.getUsername().contentEquals(u.getUsername()) && user.getPassword().contentEquals(u.getPassword()))
					return u.getId();
			}
	
		return 0;
	}

	public static int verifyusernameSignup(List<UserInfo> userList, UserBuild user){
		for(UserInfo u:userList){
			if(user.getUsername().contentEquals(u.getUsername()))
				return u.getId();
		}
		return 0;
	}
	
	
}
