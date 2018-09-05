package listeners2;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//HttpSessionBindingListener used to inform an object when it is added to or removed from a HttpSession
public class User_SessionBindingListener implements HttpSessionBindingListener {
	
	private String name;
	private String surname;
	private String city;
	private String phone;

	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User's HttpSessionBindingListener.valueBound()");
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User's HttpSessionBindingListener.valueUnbound()");
		
	}

	
	
	public User_SessionBindingListener() {}
	
	public User_SessionBindingListener(String name, String surname, String city, String phone) {
		super();
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + "]";
	}

}
