package com.example.demo.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService 
{
	@Autowired
	private MyRepository myrepo;
	
	public MyModel save(MyModel mymodel)
	{
		return myrepo.save(mymodel);
	}
	
	public MyModel get(long player_id)
	{
		
		return myrepo.findById(player_id).get();
	}
	
	public void delete(long player_id)
	{
		myrepo.deleteById(player_id);
	}
}
