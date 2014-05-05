package legalStaffViewpoint;

public class legalStaffDetails {

	private String Username;
	private String Password;
	
	/**
	 * Get users username
	 * @return
	 */
	public String getUsername() {
		return Username;
	}
	
	/**
	 * Set users suername
	 * @param username
	 */
	public void setUsername(String username) {
		Username = username;
	}
	
	/**
	 * get users password
	 * @return
	 */
	public String getPassword() {
		return Password;
	}
	
	/**
	 * Set users password
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	/**
	 * Testing credentials
	 */
	public legalStaffDetails(){
		setUsername("legal");
		setPassword("1234");
	}
	
}
