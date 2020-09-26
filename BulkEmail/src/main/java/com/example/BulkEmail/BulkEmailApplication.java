package com.example.BulkEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.BulkEmail.dao.EmployeeRepo;
import com.example.BulkEmail.model.Employees;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BulkEmailApplication {

	public static void main(String[] args) {
	SpringApplication.run(BulkEmailApplication.class, args);
	}

}

@Component
class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private EmployeeRepo emprepo;


	@Override
	public void run(String... args) throws Exception {
		
		ExecutorService service=Executors.newFixedThreadPool(10);
		long size=50000;
		long start=1;
		long upto=50000;
		while(start<1000000)
		{
			service.execute(new InsertElementsIntoH2Database(emprepo,start,upto));
			start=upto+1;
			upto=upto+size;

		}


		
	}
}

class InsertElementsIntoH2Database implements Runnable{
	private EmployeeRepo emprepo;
	private long starting;
	private long ending;
	
	public void run() {
		while(starting<=ending)
		{
			Employees emp=new Employees();
			//generating a unique name
			emp.setEmployeeName("name"+ending+" vivek"+ending);
			//generating a unique email
			emp.setEmployeeEmail("email"+ending+"@data4life"+ending+".services");		
			emprepo.save(emp);
			starting++;
		}
		
	}

	public InsertElementsIntoH2Database(EmployeeRepo emprepo, long starting, long ending) {
		super();
		this.emprepo = emprepo;
		this.starting = starting;
		this.ending = ending;
	}


}
