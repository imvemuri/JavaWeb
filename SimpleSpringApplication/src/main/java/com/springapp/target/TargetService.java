package com.springapp.target;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TargetService {

	private static List<Target> targets = new ArrayList<Target>();
	private static int count = 0;
	
	static{
		targets.add(new Target(count++,"krish",new Date(),false,"Spring"));
		targets.add(new Target(count++,"krish",new Date(),false,"Cormen"));
		targets.add(new Target(count++,"krish",new Date(),false,"LeetCode"));
		targets.add(new Target(count++,"sai",new Date(),false,"ML"));
		targets.add(new Target(count++,"sai",new Date(),false,"Kaggle"));
	}
	
	public void addTarget(String user, Date currentDate, boolean isDone, String desc){
		targets.add(new Target(count++,user,currentDate,false,desc));
	}
	
	public List<Target> retrieveTargets(String user){
		List<Target> userTargets = new ArrayList<Target>();
		for(Target Target : targets){
			if(Target.getUser().equals(user))
				userTargets.add(Target);
		}
		return userTargets;
	}
	
	public void deleteTarget(int id){
		Iterator<Target> iterator = targets.iterator();
		while (iterator.hasNext()) {
			Target Target = iterator.next();
			if (Target.getId() == id) {
				iterator.remove();
			}
		}
		return ;
	}
	
	public Target retrieveTarget(int id) {
		for (Target Target : targets) {
			if (Target.getId() == id)
				return Target;
		}
		return null;
	}

	public void updateTarget(Target Target) {
		targets.remove(Target);
		targets.add(Target);
	}
   
}
