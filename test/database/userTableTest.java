package database;

import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class userTableTest extends UnitTest {

	@Test
	public void testInserts(){
		User something = new User("rakesh","mukherjee","username","password","something@example.com");
		something.save();
		User rake =User.findById(something.id);
		assertEquals("rakesh",rake.firstname);
		rake =User.find("byUsername","username").first();
		assertEquals("rakesh",rake.firstname);
	}
}
