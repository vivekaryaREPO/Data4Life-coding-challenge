package com.example.BulkEmail.model;
import java.lang.Runnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.BulkEmail.dao.EmployeeRepo;

@Component
public class SendEmailsHelper {
	
	 @Autowired
	 EmployeeRepo emprepo;
	
	public void send(List<String> listOfEmails) {
		ExecutorService service=Executors.newFixedThreadPool(5);
		long size=listOfEmails.size();
		long min=size/10;
		long toIndex=min;
		long firstIndex=0;
		for(long i=0;toIndex<=size;i++)
		{
			firstIndex=min*i;
			toIndex=toIndex-1;
			service.execute(new SendEmails(firstIndex,listOfEmails,toIndex));
			toIndex=min*(i+2);		
		}
	}
	

}

class SendEmails implements Runnable
{	
	private long getEmailFromIndex;
	private List<String> emailIdsList;
	private long getEmailToIndex;
	public long getGetEmailFromIndex() {
		return getEmailFromIndex;
	}

	public SendEmails(long getEmailFromIndex, List<String> emailIdsList, long getEmailToIndex) {
		super();
		this.getEmailFromIndex = getEmailFromIndex;
		this.emailIdsList = emailIdsList;
		this.getEmailToIndex = getEmailToIndex;
	}


	public void setGetEmailFromIndex(long getEmailFromIndex) {
		this.getEmailFromIndex = getEmailFromIndex;
	}

	public long getGetEmailToIndex() {
		return getEmailToIndex;
	}

	public void setGetEmailToIndex(long getEmailToIndex) {
		this.getEmailToIndex = getEmailToIndex;
	}

	public SendEmails()
	{
		
	}
	
	public void run() {
		//send email logic here, i.e send the email to each email id present in the List<String> emailIdsList
		try {
		Thread.sleep(500);
	}
		catch(Exception e)
		{
			//logging the error
		}
}
	
}
