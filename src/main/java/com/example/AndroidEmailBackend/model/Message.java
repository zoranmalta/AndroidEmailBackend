package com.example.AndroidEmailBackend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="message")
@EntityListeners(AuditingEntityListener.class)
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="message_id")//dajem ime koloni koja ce biti strani kljuc u medjutabeli message_tag
	private Long id;
	
	@Column(nullable=false)
	private String sendto;
	
	private String sendcc;
	
	private String sendbc;
	@ManyToOne
	//@JsonIgnore//ne stavlja u json listu postova koja bi kasnije referencirale ne user i tako u krug 
    @JsonBackReference
    @JoinColumn(name = "account_id",nullable=false)//pravi kolonu account_id od account.getIds ne sme biti null
	@OnDelete( action=OnDeleteAction.CASCADE) //pri brisanju usera brisu se i njegovi messages
	private Account account;
	
	@Column(name="message_date" , nullable=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(pattern="YYYY-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date date;
	
	@OneToMany(mappedBy="message" ,cascade=CascadeType.ALL)//pri briasanju message brisu se i sve njegove attachments
	@JsonManagedReference // stavlja u json listu postova koja bi kasnije referencirale ne attachment i tako u krug
	private List<Attachment> attachments;
	
	@OneToMany(mappedBy = "message", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private List<Message_Tag> message_tags;
	
	@Column(name="subject" , nullable=false)
	private String subject;
	
	@Column(name="content" , nullable=false)
	private String content;
	
	public Message() {}

	public Message(Long id, String sendto, String sendcc, String sendbc,
			com.example.AndroidEmailBackend.model.Account account, Date date,
			List<com.example.AndroidEmailBackend.model.Attachment> attachments, String subject, String content) {
		super();
		this.id = id;
		this.sendto = sendto;
		this.sendcc = sendcc;
		this.sendbc = sendbc;
		this.account = account;
		this.date = date;
		this.attachments = attachments;
		this.subject = subject;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSendto() {
		return sendto;
	}

	public void setSendto(String sendto) {
		this.sendto = sendto;
	}

	public String getSendcc() {
		return sendcc;
	}

	public void setSendcc(String sendcc) {
		this.sendcc = sendcc;
	}

	public String getSendbc() {
		return sendbc;
	}

	public void setSendbc(String sendbc) {
		this.sendbc = sendbc;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Message_Tag> getMessage_tags() {
		return message_tags;
	}

	public void setMessage_tags(List<Message_Tag> message_tags) {
		this.message_tags = message_tags;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sendto=" + sendto + ", sendcc=" + sendcc + ", sendbc=" + sendbc + ", account="
				+ account + ", date=" + date + ", attachments=" + attachments + ", message_tags=" + message_tags
				+ ", subject=" + subject + ", content=" + content + "]";
	}
	
	
}
