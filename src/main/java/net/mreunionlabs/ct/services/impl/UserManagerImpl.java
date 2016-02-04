package net.mreunionlabs.ct.services.impl;

import net.mreunionlabs.ct.entities.User;
import net.mreunionlabs.ct.services.UserManager;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.grid.GridDataSource;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserManagerImpl implements UserManager {

	private Session session;

    public UserManagerImpl(Session session) {
        this.session = session;
    }


	@Override
	public void registerUser(String username, String password) {
//		User user = new User();
//		user.setName(username);
//		user.setPassword(hashGenerator.generateHash(password.getBytes()));
//
//		// persist doesn't guarantee that the id will immediately assign to the object
//		// it might happened at flush time. So we force flush to guarantee this
//		session.persist(user);
//		session.flush();
	}

	@Override
	public void add(User user) {
		session.persist(user);
	}

	@Override
	public User find(String username) {
		return (User)session.createCriteria(User.class)
				.add(Restrictions.eq("name", username))
				.uniqueResult();
	}


	public User get(Long userId) {
		return (User) session.get(User.class, userId);
	}

	public List<User> findAll() {
		return session.createCriteria(User.class)
			.list();
	}

	/*
	 * a tapestri grid data source that  
	 */
	public GridDataSource getUserDS(ComponentResources resources) {
//	    HibernateEntityDataSource<User> dataSource =
//	    	HibernateEntityDataSource.create(session, User.class, resources);
//
//	    return dataSource;
        return null;
    }

	
}
