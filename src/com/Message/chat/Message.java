package com.Message.chat;


public class Message {
	private int id;
	private int iduserfrom;
	private String from;
	private String to;
	private String date;
	private String content;
	
	public Message(int iduserfrom, int id, String from, String to, String date, String content) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.date = date;
		this.content = content;
	}
	public Message(int iduserfrom, String to, String date, String content) {
		this.iduserfrom = iduserfrom;
		this.to = to;
		this.date = date;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public int getIduserfrom() {
		return iduserfrom;
	}
	public void setIduserfrom(int iduserfrom) {
		this.iduserfrom = iduserfrom;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", from=" + from + ", to=" + to + ", date=" + date + ", content=" + content + "]";
	}
}
