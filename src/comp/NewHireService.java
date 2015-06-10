package comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("newHireService")
public class NewHireService {

	@Autowired
	NewHireDAO newHireDAO;
	
	@Override
	public String toString() {
		return "New Hire Service [New Hire DAO=" + newHireDAO + "]";
	}
}
