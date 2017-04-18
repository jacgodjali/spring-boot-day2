package com.first;
 
 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Collectors;
 
 import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.bind.annotation.RequestMethod;
 
 @Controller
 public class EmployeeController {
 
 	private List<Employee> list;
 	
 	public EmployeeController() {
 		this.list = new ArrayList<Employee>();
 		list.add(new Employee(1, "male"));
 		list.add(new Employee(2, "female"));
 		
 	}
 
 	@RequestMapping(value = "/employees", method = RequestMethod.GET)
 	@ResponseBody
 	public List<Employee> empGet(@RequestParam(value = "gender", defaultValue="male") String gender) {

 		return list.stream().filter(s->s.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
 	}
 	
 	@RequestMapping(value = "/employee", method = RequestMethod.POST)
 	@ResponseBody
 	public Employee empPost(@RequestBody Employee gender) {
 		list.add(gender);
 		return gender;
 	}
 	
 	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
 	@ResponseBody
 	public Employee idGet(@PathVariable int id) {
 		List<Employee> line = list;
 		line = line.stream().filter(s->s.getId()== id).collect(Collectors.toList());
 		boolean NotFound = line.isEmpty();
 		if (NotFound) 
 			throw new EmployeeNotFoundException();
 		return line.get(0);
 	}
 }