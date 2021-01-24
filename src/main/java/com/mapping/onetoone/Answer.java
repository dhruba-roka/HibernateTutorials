package com.mapping.onetoone;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	private int answerId;
	private String answer;
	
	@OneToOne(mappedBy = "answer")
	private Question question;
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
