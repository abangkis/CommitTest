package net.mreunionlabs.ct.services;

import net.mreunionlabs.ct.services.impl.UserManagerImpl;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.hibernate.HibernateEntityPackageManager;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.compatibility.Compatibility;
import org.apache.tapestry5.services.compatibility.Trait;

/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 *
 * Created by abangkis on 03/02/2016.
 */
public class AppModule {

    public static void bind(ServiceBinder binder) {
        binder.bind(UserManager.class, UserManagerImpl.class);
    }

    // Override tapestry default symbol using annotation instead of contributeApplicationDefaults
    @Contribute(SymbolProvider.class)
    @ApplicationDefaults
    public void disableProductionMode(MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
    }

    @Contribute(SymbolProvider.class)
    @ApplicationDefaults
    public void setSupportedLocale(MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
    }

    // disable scriptaculous so we can use JQuery
    @Contribute(Compatibility.class)
    public static void disableScriptaculous(MappedConfiguration configuration){
        configuration.add(Trait.SCRIPTACULOUS, false);
    }

    @Contribute(HibernateEntityPackageManager.class)
    public static void setHibernate(Configuration<String> configuration) {
        configuration.add("net.mreunionlabs.ct.entities");
    }
}
