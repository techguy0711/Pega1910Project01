package com.revature.bean;

import java.util.Date;
import java.util.Timer;

public class TuitionReimbursementForm {
	private int form_id;
	private String employee_username;
	private String employee_first;
	private String employee_last;
	private String submit_date;
	private String start_date;
	private String submit_time;
	private String city;
	private String state;
	private int zip;
	private String description;
	private Double class_cost;
	private Double reimbursment_amount;
	private String passing_grade;
	private String event_type;
	private String work_related_justification;
	private int work_time_missed;
	private String requested_information;
	private boolean ds_approval;
	private boolean dh_approval;
	private boolean bc_approval;
	private boolean optional_info;
	private boolean final_approval;
	
	public TuitionReimbursementForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TuitionReimbursementForm(int form_id, String employee_username, String employee_first, String employee_last,
			String submit_date, String start_date, String submit_time, String city, String state, int zip,
			String description, Double class_cost, Double reimbursment_amount, String passing_grade, String event_type,
			String work_related_justification, int work_time_missed, String requested_information, boolean ds_approval,
			boolean dh_approval, boolean bc_approval, boolean optional_info, boolean final_approval) {
		super();
		this.form_id = form_id;
		this.employee_username = employee_username;
		this.employee_first = employee_first;
		this.employee_last = employee_last;
		this.submit_date = submit_date;
		this.start_date = start_date;
		this.submit_time = submit_time;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.description = description;
		this.class_cost = class_cost;
		this.reimbursment_amount = reimbursment_amount;
		this.passing_grade = passing_grade;
		this.event_type = event_type;
		this.work_related_justification = work_related_justification;
		this.work_time_missed = work_time_missed;
		this.requested_information = requested_information;
		this.ds_approval = ds_approval;
		this.dh_approval = dh_approval;
		this.bc_approval = bc_approval;
		this.optional_info = optional_info;
		this.final_approval = final_approval;
	}

	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public String getEmployee_first() {
		return employee_first;
	}

	public void setEmployee_first(String employee_first) {
		this.employee_first = employee_first;
	}

	public String getEmployee_last() {
		return employee_last;
	}

	public void setEmployee_last(String employee_last) {
		this.employee_last = employee_last;
	}

	public String getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getClass_cost() {
		return class_cost;
	}

	public void setClass_cost(Double class_cost) {
		this.class_cost = class_cost;
	}

	public Double getReimbursment_amount() {
		return reimbursment_amount;
	}

	public void setReimbursment_amount(Double reimbursment_amount) {
		this.reimbursment_amount = reimbursment_amount;
	}

	public String getPassing_grade() {
		return passing_grade;
	}

	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getWork_related_justification() {
		return work_related_justification;
	}

	public void setWork_related_justification(String work_related_justification) {
		this.work_related_justification = work_related_justification;
	}

	public int getWork_time_missed() {
		return work_time_missed;
	}

	public void setWork_time_missed(int work_time_missed) {
		this.work_time_missed = work_time_missed;
	}

	public String getRequested_information() {
		return requested_information;
	}

	public void setRequested_information(String requested_information) {
		this.requested_information = requested_information;
	}

	public boolean isDs_approval() {
		return ds_approval;
	}

	public void setDs_approval(boolean ds_approval) {
		this.ds_approval = ds_approval;
	}

	public boolean isDh_approval() {
		return dh_approval;
	}

	public void setDh_approval(boolean dh_approval) {
		this.dh_approval = dh_approval;
	}

	public boolean isBc_approval() {
		return bc_approval;
	}

	public void setBc_approval(boolean bc_approval) {
		this.bc_approval = bc_approval;
	}

	public boolean isOptional_info() {
		return optional_info;
	}

	public void setOptional_info(boolean optional_info) {
		this.optional_info = optional_info;
	}

	public boolean isFinal_approval() {
		return final_approval;
	}

	public void setFinal_approval(boolean final_approval) {
		this.final_approval = final_approval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bc_approval ? 1231 : 1237);
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((class_cost == null) ? 0 : class_cost.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (dh_approval ? 1231 : 1237);
		result = prime * result + (ds_approval ? 1231 : 1237);
		result = prime * result + ((employee_first == null) ? 0 : employee_first.hashCode());
		result = prime * result + ((employee_last == null) ? 0 : employee_last.hashCode());
		result = prime * result + ((employee_username == null) ? 0 : employee_username.hashCode());
		result = prime * result + ((event_type == null) ? 0 : event_type.hashCode());
		result = prime * result + (final_approval ? 1231 : 1237);
		result = prime * result + form_id;
		result = prime * result + (optional_info ? 1231 : 1237);
		result = prime * result + ((passing_grade == null) ? 0 : passing_grade.hashCode());
		result = prime * result + ((reimbursment_amount == null) ? 0 : reimbursment_amount.hashCode());
		result = prime * result + ((requested_information == null) ? 0 : requested_information.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((submit_date == null) ? 0 : submit_date.hashCode());
		result = prime * result + ((submit_time == null) ? 0 : submit_time.hashCode());
		result = prime * result + ((work_related_justification == null) ? 0 : work_related_justification.hashCode());
		result = prime * result + work_time_missed;
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		TuitionReimbursementForm other = (TuitionReimbursementForm) obj;
		if (bc_approval != other.bc_approval)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (class_cost == null) {
			if (other.class_cost != null)
				return false;
		} else if (!class_cost.equals(other.class_cost))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dh_approval != other.dh_approval)
			return false;
		if (ds_approval != other.ds_approval)
			return false;
		if (employee_first == null) {
			if (other.employee_first != null)
				return false;
		} else if (!employee_first.equals(other.employee_first))
			return false;
		if (employee_last == null) {
			if (other.employee_last != null)
				return false;
		} else if (!employee_last.equals(other.employee_last))
			return false;
		if (employee_username == null) {
			if (other.employee_username != null)
				return false;
		} else if (!employee_username.equals(other.employee_username))
			return false;
		if (event_type == null) {
			if (other.event_type != null)
				return false;
		} else if (!event_type.equals(other.event_type))
			return false;
		if (final_approval != other.final_approval)
			return false;
		if (form_id != other.form_id)
			return false;
		if (optional_info != other.optional_info)
			return false;
		if (passing_grade == null) {
			if (other.passing_grade != null)
				return false;
		} else if (!passing_grade.equals(other.passing_grade))
			return false;
		if (reimbursment_amount == null) {
			if (other.reimbursment_amount != null)
				return false;
		} else if (!reimbursment_amount.equals(other.reimbursment_amount))
			return false;
		if (requested_information == null) {
			if (other.requested_information != null)
				return false;
		} else if (!requested_information.equals(other.requested_information))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (submit_date == null) {
			if (other.submit_date != null)
				return false;
		} else if (!submit_date.equals(other.submit_date))
			return false;
		if (submit_time == null) {
			if (other.submit_time != null)
				return false;
		} else if (!submit_time.equals(other.submit_time))
			return false;
		if (work_related_justification == null) {
			if (other.work_related_justification != null)
				return false;
		} else if (!work_related_justification.equals(other.work_related_justification))
			return false;
		if (work_time_missed != other.work_time_missed)
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TuitionReimbursementForm [form_id=" + form_id + ", employee_username=" + employee_username
				+ ", employee_first=" + employee_first + ", employee_last=" + employee_last + ", submit_date="
				+ submit_date + ", start_date=" + start_date + ", submit_time=" + submit_time + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", description=" + description + ", class_cost=" + class_cost
				+ ", reimbursment_amount=" + reimbursment_amount + ", passing_grade=" + passing_grade + ", event_type="
				+ event_type + ", work_related_justification=" + work_related_justification + ", work_time_missed="
				+ work_time_missed + ", requested_information=" + requested_information + ", ds_approval=" + ds_approval
				+ ", dh_approval=" + dh_approval + ", bc_approval=" + bc_approval + ", optional_info=" + optional_info
				+ ", final_approval=" + final_approval + "]";
	}

}
