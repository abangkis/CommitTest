package net.mreunionlabs.ct.services;

import net.mreunionlabs.ct.entities.User;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.grid.GridDataSource;

import java.util.List;

public interface UserManager {

    public void registerUser(String username, String password);

    public User get(Long id);

    public User find(String username);

    public List<User> findAll();

    public void add(User user);

    public GridDataSource getUserDS(ComponentResources resources);
}
