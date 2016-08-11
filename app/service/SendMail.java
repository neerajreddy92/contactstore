package service;
/**
 * service class to send a new email.
 * @author Neeraj
 *
 */
public class SendMail {
	/**
	 * sends a new email based on the paramerter given.
	 * @param to email address of the receiver 
	 * @param contactName  contact name 
	 * @param userFullName receivers name 
	 * @return
	 */
	public static boolean send(String to,String contactName,String userFullName ){
		 try {
             GmailSender sender = new GmailSender("contactstoreforyou@gmail.com", "somethingawesome");
             String body= "Hello "+contactName+", \n your contact "+userFullName+ "birth day is tommorow.Dont forget to wish him \n regards \n your friends at contactstore"; 
             sender.sendMail("Your Contacts Birthday is coming up", body, "contactstoreforyou@gmail.com", to);
             return true;
         } catch (Exception e) {
        	 System.out.println(e.getMessage().toString());
             e.printStackTrace();
             return false;
         }
		
	}
}
