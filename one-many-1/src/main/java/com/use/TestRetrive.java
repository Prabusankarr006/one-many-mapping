package com.use;

	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.query.Query;


	//import org.hibernate.Session;
	//
	//import org.hibernate.Transaction;

	public class TestRetrive {
	  public static void main(String args[]) {
	    Transaction tr = null;
	    try(Session ses =HBUtil.getSf().openSession()){
	        tr=ses.beginTransaction();
	       	Query <	Question > qry=ses.createQuery("from Question",Question.class);
	       	List<Question>li=qry.list();
	       	for(Question a:li) {
	       		System.out.println(a.getId()+"\t"+a.getQuestion());
	       		List<Answer> ans =a.getAnswers();
		       	for(Answer b:ans) {
		       		System.out.println(b.getAnswername()+"\t"+b.getPostedby());
		       		
	       	}
		       	
	       	}
	       	tr.commit();
	       	ses.close();
	           }
	    catch(Exception e) {
	      e.printStackTrace();
	    }
	  }
	}

