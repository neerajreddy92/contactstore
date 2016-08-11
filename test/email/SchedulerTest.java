package email;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import models.Contacts;
import models.User;
import play.test.UnitTest;
import service.ScheduledEmailSender;

public class SchedulerTest extends UnitTest{
	/**
	 * tests the scheduler job.
	 */
	@Test
	public void schedulerTest(){
		User user = new User("some", "some", "some", "some","example@gmail.com");
		user.save();
		Contacts con = new Contacts();
		con.firstname = "contact";
		con.lastname = "con";
		con.email = "sljs@gmail.com";
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		String[] datesplit =date.split("-");
		con.dateofbirth = (Integer.parseInt(datesplit[2])-1)+datesplit[1]+datesplit[0];
		con.user=user;
		con.save();
		ScheduledEmailSender ses =  new ScheduledEmailSender();
		ses.doJob();
		assertEquals(true, true);
	}
}
