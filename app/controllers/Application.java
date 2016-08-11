package controllers;

import play.*;
import play.data.validation.Valid;
import play.mvc.*;
import java.util.*;
import models.*;
/**
 * application controller main 
 * @author Neeraj
 *
 */
public class Application extends Controller {
	/**
	 * home controller
	 */
    public static void index() {
    	if(authorized() != null) {
    		 LoggedIn.index();
        }
    	render();
    }
    /**
     * function to check the authentication of all requests. 
     * @return
     */
    static User authorized() {
        if(renderArgs.get("user") != null) {
            return renderArgs.get("user", User.class);
        }
        String username = session.get("user");
        if(username != null) {
            return User.find("byUsername", username).first();
        } 
        return null;
    }
    /**
     * login controller
     * @param username
     * @param password
     */
    public static void login(String username, String password) {
        User user = User.find("byUsernameAndPassword", username, password).first();
        if(user != null) {
            session.put("user", user.username);
            flash.success("Welcome, " + user.firstname+" "+user.lastname);
            LoggedIn.index();
        }
        // Oops
        flash.put("username", username);
        flash.error("Login failed");
        index();
    }
    /**
     * new user conroller 
     * @param user user model 
     * @param verifyPassword
     */
    public static void saveUser(@Valid User user, String verifyPassword) {
        validation.required(verifyPassword);
        validation.equals(verifyPassword, user.password).message("Your password doesn't match");
        User u = User.find("byUsername", user.username).first();
        if(u!=null){
        	flash.error("user name already exists");
            render("@register", user, verifyPassword);
        }
        if(validation.hasErrors()) {
        	flash.error("error");
            render("@register", user, verifyPassword);
        }
        user.create();
        session.put("user", user.username);
        flash.success("Welcome, " + user.firstname+" "+user.lastname);
        LoggedIn.index();
    }
    /**
     * register GET controller
     */
    public static void register() {
    	render();
    }
    /**
     * register POST controller
     */
    public static void logout() {
        session.clear();
        index();
    }

}