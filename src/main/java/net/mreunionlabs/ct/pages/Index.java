package net.mreunionlabs.ct.pages;

import net.mreunionlabs.ct.entities.User;
import net.mreunionlabs.ct.services.UserManager;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by abangkis on 03/02/2016.
 */
public class Index {
    @Inject
    private Logger logger;

    @Inject
    private UserManager userManager;

    @SetupRender
    void setupRender(){
        logger.debug("Setup render");
        List<User> users = userManager.findAll();
        for (User user : users) {
            logger.debug("user : " + user.getName());
        }

    }

//    @Inject
//    private HibernateSessionManager manager;

    @CommitAfter
    public void onActionFromAdd(){
        logger.debug("trying add with commit after");

        User user = new User();
        user.setPassword("");
        user.setName("testing user 3");

        userManager.add(user);
//        try {
//            manager.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
