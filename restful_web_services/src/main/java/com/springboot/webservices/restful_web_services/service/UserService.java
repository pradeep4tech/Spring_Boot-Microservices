package com.springboot.webservices.restful_web_services.service;

import java.awt.desktop.UserSessionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.webservices.restful_web_services.bean.UserBean;

@Component
public class UserService {

	static List<UserBean> userList = new ArrayList<UserBean>();
	private static int usercount = 3;
	static {
		userList.add(new UserBean(1, "pradeep", new Date()));
		userList.add(new UserBean(2, "kumar", new Date()));
		userList.add(new UserBean(3, "osuru", new Date()));
	}

	public UserBean findById(Integer id) {
		for (UserBean user : userList) {
			if (user.getId().equals(id)) {
				return user;
			}

		}
		return null;
	}

	public List<UserBean> listUsers() {
		return userList;
	}

	public UserBean save(UserBean userBean) {
		if (userBean.getId() == null) {
			userBean.setId(++usercount);
		}
		userList.add(userBean);
		return userBean;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Iterator<UserBean> it=userList.iterator();
		while (it.hasNext()) {
			UserBean user=(UserBean) it.next();
			if (user.getId().equals(id)) {
				it.remove();
			}

		}
	}

}
