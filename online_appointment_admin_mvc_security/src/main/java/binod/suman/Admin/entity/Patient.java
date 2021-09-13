package binod.suman.Admin.entity;


public class Patient {

	
	private String email;
	private String name;
	private String password;
	private int age;
	private int mobile;
	private String gender;
	public Patient() {}
	public Patient(String email, String name, String password, int mobile) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Patient [email=" + email + ", name=" + name + ", password=" + password + ", age=" + age + ", mobile="
				+ mobile + ", gender=" + gender + "]";
	}
	
	 
}
