package com.library.daos;

import com.library.models.Login;

public interface LoginDao {
	public Login validate(String loginId,String pass);
}
