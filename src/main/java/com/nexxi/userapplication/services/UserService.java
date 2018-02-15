package com.nexxi.userapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.nexxi.userapplication.db.DBFactory;
import com.nexxi.userapplication.models.User;

@Service
public class UserService {

	@Autowired
	private DBFactory db;
	private Database database;
	
	public List<User> getListOfUsers() {
		// TODO Auto-generated method stub
		database = db.getSchoolDb();
		return database.results(User.class);
	}

	public String addingUser(User user) {
		// TODO Auto-generated method stub
		database = db.getSchoolDb();
		int rowEffected = database.insert(user).getRowsAffected();
		if(rowEffected<=0){
			return "failed";
		}
		return "Success";
	}

	public String updatingUser(Long id, User user) {
		database = db.getSchoolDb();
		// TODO Auto-generated method stub
		user.setId(id);
		int rowEffected = database.update(user).where("id =?", id).getRowsAffected();
		if(rowEffected<=0){
			return "failed";
		}
		return "Success";
	}

	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(id);
		int rowEffected = database.delete(user).getRowsAffected();
		if(rowEffected<=0){
			return "failed";
		}
		return "Success";
	}

}
