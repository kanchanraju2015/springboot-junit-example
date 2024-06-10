package com.briz.myunittest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// to define the order of test case execution otherwise it will run randomly
 //however we can define the random by this annotation also
class MyunittestApplicationTests
{
@Autowired
EmployeeRepository erepo;
// this is for repository test 
// use autowired for service and controller test also

	@Test
	@Order(1)
	void createTest()
	{
	Employee e=new Employee();
	e.setId(152); // check for it 
	e.setAge(88);
	e.setCity("delhi");
	e.setName("rajan");
	erepo.save(e);
	assertNotNull(erepo.findById(152).get());// id must not be equal to null
	}

@Test
@Order(2)
public void testSingle()
{
	Employee employee=erepo.findById(152).get();
	assertEquals(152,employee.getId());// checking for the id present id
}
@Test
@Order(3)
public void updatetest()
{
	Employee employee=erepo.findById(152).get();
	employee.setAge(53);
	erepo.save(employee);
	assertNotEquals(52,erepo.findById(152).get().getAge());// checking for age must not 
}

@Test
@Order(4)
public void allTest()
{
	List<Employee> employee=erepo.findAll();
	assertNotEquals(0,employee.size());
}

@Test
public void testDelete()
{
	erepo.deleteById(102l);
	assertThat(erepo.existsById(102l)).isFalse();
	
}
}
