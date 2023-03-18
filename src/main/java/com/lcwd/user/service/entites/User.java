package com.lcwd.user.service.entites;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "micro_user")
public class User {

	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "NAME", length = 20)
	private String name;
	@Column(name = "Email", length = 25)
	private String email;
	@Column(name = "ABOUT")
	private  String about;

	   @Transient
	private List<Rating> ratings = new ArrayList<>();
	}
