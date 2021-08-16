package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "response")
@NoArgsConstructor
public @Data class Response {


	public Response(String content, int postId, Integer userId, String username) {

		this.content = content;
		this.postId = postId;
		this.userId = userId;
		this.username= username;
	}

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "post_id")
	private int postId;

    @Column(name = "userId")
    private Integer userId;

    
    @Column(name="username")
    private String username;
    
//	@ManyToOne(fetch = FetchType.LAZY, optional=false)
//	  @JoinColumns({
//		    @JoinColumn(name = "userId", referencedColumnName="userId", nullable=false, insertable=false, updatable=false),
//			@JoinColumn(name = "username", referencedColumnName="username", nullable=false, insertable=false, updatable=false)
//	  })
//
//	@JsonBackReference
//	private User user;
//	
//	@ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "post_id", referencedColumnName="post_id", nullable=false, insertable=false, updatable=false)
//	private Posts post;
    
}