package com.mapping.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("com/mapping/onetomany/onetomanyhibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating Question:
		Question question = new Question();
		question.setQuestionId(1221);
		question.setQuestion("what is java?");
		
		//creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(20);
		answer1.setAnswer("java is programming language");
		answer1.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(21);
		answer2.setAnswer("java can create softwares");
		answer2.setQuestion(question);
		
		Answer answer3 = new Answer();
		answer3.setAnswerId(22);
		answer3.setAnswer("java is very secure language");
		answer3.setQuestion(question);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		question.setAnswers(list);
		
		
		

		
		//session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//save
		session.save(question);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		
		
		tx.commit();
		
	//fetching
	//	Question newQ = session.get(Question.class, 2323);
	//	System.out.println(newQ.getQuestion());
	//System.out.println(newQ.getAnswer().getAnswer());
		
		
		session.close();
		factory.close();
	}

}
