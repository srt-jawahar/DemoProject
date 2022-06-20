package com.example.demo.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
	@Autowired
	private MyRepository myrepo;
	private MyService myservice;
	
	
	public MyModel savemymodel(MyModel mymodel)
	{
		return myrepo.save(mymodel);
	}
	
	@GetMapping("records/get")
	public MyModel stats_list(long player_id)
	{
		return myrepo.findById(player_id).orElse(null);
	}
	
	@DeleteMapping("records/delete")
	public String cancelrecord(long player_id)
	{
		myrepo.deleteById(player_id);
		return "Deletion successful";	
	}
	
	@PostMapping("records/post")
	public MyModel postrecords(MyModel mymodel)
	{
		return myservice.save(mymodel);
	}
	
	@GetMapping("record")
	public String records()
	{
		return "Records";
		
	}
}
