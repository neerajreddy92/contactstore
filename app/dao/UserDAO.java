package dao;

import models.User;
import play.Logger;
import play.db.jpa.Transactional;
/**
 * database access layer with function to talk to the db. 
 * @author Neeraj
 *
 */
public class UserDAO implements java.io.Serializable{
	
	public User getUserByID(Long id){
		if(id == null) return null;
		return User.findById(id);
	}
	public User getUserByUserName(String username){
		if(username==null) return null;
		return User.find("byUsername", username).first();
	}
	
	@Transactional 
	public boolean deleteUserById(Long id){
		if(id==null) return false;
		Logger.debug("Delete User Id: "+id);
		if(User.delete("byId",id)>0)
			return true;
		return false;
	}
}
