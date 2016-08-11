package email;

import org.junit.Test;

import play.test.UnitTest;
import service.SendMail;

public class SendEmailTest extends UnitTest{
	@Test
	public void sendmailtest(){
		assertEquals(true, SendMail.send("reddy.neeraj007@gmail.com", "neeraj", "some random guy"));
		}
	
	@Test
	public void sendWrongmailtest(){
		assertEquals(false, SendMail.send("reddy.com", "neeraj", "some random guy"));
		}
	
}
