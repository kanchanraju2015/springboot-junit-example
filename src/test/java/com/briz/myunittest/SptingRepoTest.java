package com.briz.myunittest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest   // must be declared only for the custom test classes

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SptingRepoTest
{

	@Autowired 
	EmployeeRepository erepo;
	@Test
	public void saveTest()
	{
		Employee employee=new Employee();
	
		employee.setAge(12);
		employee.setCity("paris");
		employee.setName("chanda rani");
		erepo.save(employee);
		//Assertions.assertThat(employee.getId()).isGreaterThan(0);
		 assertNotNull(erepo.findById(202).get()); // for this create method findbyid in repo pass the id present into database
		
	}   
	@Test
	public void singleElementTest()
	{
	Employee employee=erepo.findById(202).get(); // present into table 
	//Assertions.assertThat(employee.getId()).isNotNull();// 52 is present in table will pass otherwise fail
	 //assertNotNull(erepo.findById(52).get());// 52 id present cannot be null
	//assertThat(erepo.findById(52)).isNotEmpty();// test for id 52 present into table not empty 
	 //assertNotEquals(52,erepo.findById(52).get().getAge());// check for age byid not equals 52 pass
	   //assertEquals(67,erepo.findById(52).get().getAge());// check for age by id 67 present pass
	}
	@Test
	public void allEmployeeTest()
	{
		List<Employee> employee=erepo.findAll();
		assertNotEquals(0,erepo.findAll().size()); // this will pass size is >0
		//assertEquals(0,erepo.findAll().size()); // this will fail many records into the database
		
	}
	@Test
	
		public void updatetest()
		{
			Employee employee=erepo.findById(202).get();
			employee.setAge(53);
			erepo.save(employee);
			assertNotEquals(67,erepo.findById(202).get().getAge());// checking for age must not 
		}
	@Test
	public void deleteTest()
	{
		erepo.deleteById(252l); // l must in delete checkit out 
		assertThat(erepo.existsById(252l)).isFalse();
	}
	}
