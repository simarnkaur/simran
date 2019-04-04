package com.library.daos;

import com.library.models.Student;

public interface StudentDao {

public boolean registerStudent(Student StudObj);
public Student getUser(String email);
public boolean updateStudent(Student StudObj);
public boolean changePassword(String email,String newPassword,String ConfirmPassword);
}
