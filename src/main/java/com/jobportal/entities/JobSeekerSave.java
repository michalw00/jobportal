package com.jobportal.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = {"userId", "job"})
})
public class JobSeekerSave implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "user_account_id")
	private JobSeekerProfile user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job", referencedColumnName = "jobPostId")
	private JobPostActivity job;

	public JobSeekerSave(Integer id, JobSeekerProfile user, JobPostActivity job) {
		this.id = id;
		this.user = user;
		this.job = job;
	}

	public JobSeekerSave() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public JobSeekerProfile getUser() {
		return user;
	}

	public void setUser(JobSeekerProfile user) {
		this.user = user;
	}

	public JobPostActivity getJob() {
		return job;
	}

	public void setJob(JobPostActivity job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "JobSeekerSave{" +
				"id=" + id +
				", user=" + user +
				", job=" + job +
				'}';
	}
}
