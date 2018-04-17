package testSpringHello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.summer.model.User;
import com.summer.service.Service;

public class UserServiceTest {
	@Test
	public void test() {
		BeanFactory bf = new ClassPathXmlApplicationContext("beans.xml");
		
		User u = new User();
		u.setAge(20);
		u.setName("jay2");
		Service service = (Service)bf.getBean("service");
		service.add(u);
	}
}
