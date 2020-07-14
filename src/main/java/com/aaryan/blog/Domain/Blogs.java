package com.aaryan.blog.Domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="blogs")

public class Blogs {
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blogid")
	private int id;
	
	@Column(name="heading")
	@NotBlank
	private String heading;
	
	@Column(name="body")
	@NotBlank
	private String blogbody;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="user_info_id")
	private UserInfo userinfo;







}
