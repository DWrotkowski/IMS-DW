package com.qa.ims.account;


public class User {
	private String username, password;
	

	public User(String username, String password){
		setUsername(username);
		setPassword(password);
	}
	public String getUsername(){
		return username;
	}

	public String getPassword(){
		return password;
	}
	public void setUsername(String username){
		this.username = username; 
	}

	public void setPassword(String password){
		this.password = password;
	}
	//load password user input and compare with User.password
	public boolean checkPassword(String password){			
		if(this.password.equals(password)){
			return true; 
		}
		else{
			return false; 
		}		
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
