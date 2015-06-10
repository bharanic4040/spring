package comp.orm;

import java.util.List;

 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
@Repository
public class UserDAOImpl implements UserDAO  {
   
	
 
    public UserDAOImpl() {
    }
 
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
        }
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
    public List<User> list() {      
        String hql = "from User";
        List<User> listUser=(List<User>)this.getSessionFactory().getCurrentSession().createQuery(hql).list();
         return listUser;
    }
 
}