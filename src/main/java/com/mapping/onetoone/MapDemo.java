package com.mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/mapping/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Question:
		Question question = new Question();
		question.setQuestionId(1221);
		question.setQuestion("what is java?");
		
		//creating answer
		Answer answer = new Answer();
		answer.setAnswerId(2323);
		answer.setAnswer("java is programming language");
		answer.setQuestion(question);
		question.setAnswer(answer);
		
		//creating Question1:
				Question question1 = new Question();
				question1.setQuestionId(1221);
				question1.setQuestion("what is java?");
				
				//creating answer1
				Answer answer1 = new Answer();
				answer1.setAnswerId(2323);
				answer1.setAnswer("java is programming language");
				answer1.setQuestion(question1);
				question1.setAnswer(answer);

		
		//session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
		session.save(question);
		session.save(question1);
		session.save(answer);
		session.save(answer1);
		
		tx.commit();
		
	//fetching
	//	Question newQ = session.get(Question.class, 2323);
	//	System.out.println(newQ.getQuestion());
	//System.out.println(newQ.getAnswer().getAnswer());
		
		
		session.close();
		factory.close();
	}

}
