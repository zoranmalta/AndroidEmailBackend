package com.example.AndroidEmailBackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tag_id")
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(mappedBy = "tag", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Message_Tag> message_tags;

	public Tag(){}
	
	public Tag(Long id, String name, List<Message_Tag> message_tags) {
		super();
		this.id = id;
		this.name = name;
		this.message_tags = message_tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message_Tag> getMessage_tags() {
		return message_tags;
	}

	public void setMessage_tags(List<Message_Tag> message_tags) {
		this.message_tags = message_tags;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", message_tags=" + message_tags + "]";
	}
	
	

}
