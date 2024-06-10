package com.briz.myunittest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "this is test only";
}
@RequestMapping("/save")
public String save()
{
	Employee e=new Employee();
	e.setId(2l); // this will not work type is auto i.e will start from 0 always.
	e.setAge(32);
	e.setCity("tata");
	e.setName("animesh kumar");
	erepo.save(e);
	return "data saved to database";
}
@RequestMapping("/all")
public List<Employee> alldata()
{
	return erepo.findAll();
}
}
