package controller;

import play.test.UnitTest;
import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;
public class SecurityTest extends FunctionalTest{
	@Test
	public void testAdminSecurity() {
	    Response response = GET("/contacts");
	    assertStatus(302, response);
	    assertHeaderEquals("Location", "/", response);
	}
}
