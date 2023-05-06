package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.User;

public class UserDao {
EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
 EntityManager manager=entityManagerFactory.createEntityManager();
 EntityTransaction entityTransaction=manager.getTransaction();
 
 public void save(User user)
 {
	 entityTransaction.begin();
	 manager.persist(user);
	 entityTransaction.commit();
 }
 
public User find(int userid) {
	return manager.find(User.class, userid);
}

public void update(User user) {
	 entityTransaction.begin();
	 manager.merge(user);
	 entityTransaction.commit();
	
}


}

