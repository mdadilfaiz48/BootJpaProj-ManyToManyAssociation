package com.adil.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.adil.service.ICollegeMgmtService;

@Component
public class ManyToManyAssociationMappingTestRunner implements CommandLineRunner {
	
	@Autowired
	private ICollegeMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		
		  /*try { service.saveDataUsingParent();
		  
		  }catch(Exception e) { e.printStackTrace(); }*/
		 
		
		

		/*
		 * try { service.loadDataUsingParent();
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
		
		try {
			  service.deleteDataUsingParent();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
