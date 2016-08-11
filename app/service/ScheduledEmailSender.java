package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import models.Contacts;
import play.jobs.Every;
import play.jobs.Job;
/**
 * schedules a job every 1day to send all the birthday mails.
 * @author Neeraj
 *
 */
@Every("1d")
public class ScheduledEmailSender extends Job<String>{
	 public void doJob() {
		    // todo: change the query to bring only relavant dates. 
	        List<Contacts> contacts = Contacts.findAll();
	        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	        int day = Integer.parseInt(date.split("-")[0]);
	        int month = Integer.parseInt(date.split("-")[1]);
	        for(Contacts contact: contacts){
	        	int personday = Integer.parseInt(contact.dateofbirth.split("-")[0]);
	        	int personmonth = Integer.parseInt(contact.dateofbirth.split("-")[1]);
	        	if(personmonth == month && day-personday==0){
	        		SendMail.send(contact.user.email, contact.firstname+" "+contact.lastname, contact.user.firstname+" "+contact.user.lastname);
	        	}
	        }
	    }
}
