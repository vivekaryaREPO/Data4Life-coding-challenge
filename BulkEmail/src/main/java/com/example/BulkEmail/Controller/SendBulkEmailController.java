package com.example.BulkEmail.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.BulkEmail.dao.EmployeeRepo;
import com.example.BulkEmail.model.SendEmailsHelper;


@Controller
//@RequestMapping("/sendBulkEmail")
public class SendBulkEmailController {
	
	 @Autowired
	 EmployeeRepo emprepo;
	 
		@RequestMapping("home")
		public String home()
		{
			while(((List<String>)emprepo.findByAllEmail()).size()<1000000)
			{
				
			}
			return "home.jsp";
		}

	
	@RequestMapping("/sendEmails")
	public String sendEmails()
	{
		SendEmailsHelper sendemailhelper=new SendEmailsHelper();
		sendemailhelper.send((List<String>)emprepo.findByAllEmail());
		return "mailSent.jsp";
	}
	
}
