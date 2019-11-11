package com.revature.bean;

public class Users {
	private int user_id;
	private String user_username;
	private String user_password;
	private int user_type;
	private double available_reimbursment;

	public Users() {
		super();
	}

	public Users(int user_id, String user_username, String user_password, int user_type,
			double available_reimbursment) {
		super();
		this.user_id = user_id;
		this.user_username = user_username;
		this.user_password = user_password;
		this.user_type = user_type;
		this.available_reimbursment = available_reimbursment;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public double getAvailable_reimbursment() {
		return available_reimbursment;
	}

	public void setAvailable_reimbursment(double available_reimbursment) {
		this.available_reimbursment = available_reimbursment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(available_reimbursment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + user_id;
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + user_type;
		result = prime * result + ((user_username == null) ? 0 : user_username.hashCode());
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
		Users other = (Users) obj;
		if (Double.doubleToLongBits(available_reimbursment) != Double.doubleToLongBits(other.available_reimbursment))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_type != other.user_type)
			return false;
		if (user_username == null) {
			if (other.user_username != null)
				return false;
		} else if (!user_username.equals(other.user_username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_username=" + user_username + ", user_password=" + user_password
				+ ", user_type=" + user_type + ", available_reimbursment=" + available_reimbursment + "]";
	}

}