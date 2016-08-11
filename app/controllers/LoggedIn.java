package controllers;

import java.util.List;
import models.Contacts;
import play.data.validation.Valid;
import play.mvc.Before;
/**
 * logged user controller
 * @author Neeraj
 *
 */
public class LoggedIn extends Application{
	 /**
	  * user authorization checker
	  */
    @Before
    static void checkUser() {
        if(authorized() == null) {
            flash.error("Please log in first");
            Application.index();
        }
    }
    /**
     * user home page controller 
     */
    public static void index() {
        List<Contacts> allcontacts = Contacts.find("byUser", authorized()).fetch();
        render(allcontacts);
    }
    /**
     * delete contact controller
     * @param id
     */
    public static void deletecontact(long id){
    	Contacts con = Contacts.findById(id);
    	con.delete();
    	index();
    }
    /**
     * new contact controller
     * @param contacts
     */
    public static void saveContact( Contacts contacts){
    	contacts.user=authorized();
    	validation.valid(contacts);
    	if(validation.hasErrors()){
    		render("@newContact",contacts);
    	}
    	contacts.create();
    	flash.success("contact added successfully");
    	index();
    }
    /**
     * new contact GET controller
     */
    public static void newContact(){
    	render();
    }
}
