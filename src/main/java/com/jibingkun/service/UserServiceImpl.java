package com.jibingkun.service;

import org.springframework.stereotype.Service;

/**
 * @author junjin4838
 * @date 2016年7月29日
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	public void insert() {
		System.out.println(this.getClass().getName()+"   insert");
	}

	public void remove() {
		System.out.println(this.getClass().getName()+"   remove");
	}

	public void delete() {
		System.out.println(this.getClass().getName()+"   delete");
	}

	public void update() {
		System.out.println(this.getClass().getName()+"  update");
	}

	public void getUser() {
		System.out.println(this.getClass().getName()+"  getUser");
	}

}
