import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.devops.entity.Role;
import tn.esprit.devops.entity.User;
import tn.esprit.devops.service.IUserService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testRestrieveAllUsersFirst(){
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
		
	}
	
	@Test
	@Order(2)
	public void  testAddUser() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.parse("2021-10-10");
		User u = new User ("Ben Amor","Mohamed",d,Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}
	
	@Test
	@Order(3)
	public void testRestrieveAllUsersSecond(){
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(1, listUsers.size());
	}
	
	@Test
	@Order(4)
	public void  testUpdateUser() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.parse("2021-10-10");
		User u = new User (1L,"Hermi","Nour",d,Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}
	
	@Test
	@Order(5)
	public void testRetrieveUser(){
		User userRetieved = us.retrieveUser("1");
		Assertions.assertEquals(1L, userRetieved.getId());
	}
	
	@Test
	@Order(6)
	public void testDeletUser(){
		us.deleteUser("1");
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}
}
