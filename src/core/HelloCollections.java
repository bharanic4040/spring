package core;
 
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

public class HelloCollections {

	private List<Integer> lists;
	private Set<Integer> sets;
    
	
	public List<Integer> getLists() {
		return lists;
	}

	public void setLists(List<Integer> lists) {
		this.lists = lists;
	}

	public Set<Integer> getSets() {
		return sets;
	}

	public void setSets(Set<Integer> sets) {
		this.sets = sets;
	}

	
	
	
}
