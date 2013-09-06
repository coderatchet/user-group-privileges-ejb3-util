package com.thenaglecode.services;

import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 3:34 PM
 */
public abstract class UserGroupPrivilegeMappingService {

    private static ServiceLoader<UserGroupPrivilegeMappingService> groupPrivilegeMappingServiceLoader
            = ServiceLoader.load(UserGroupPrivilegeMappingService.class);

    public static UserGroupPrivilegeMappingService getUserGroupPrivilegeMappingService() throws ServiceConfigurationError {
        for (UserGroupPrivilegeMappingService service : groupPrivilegeMappingServiceLoader) {
            if (service != null) {
                return service;
            }
        }
        return null;
    }

    /**
     * this method will return whether or not the specified group contains the specified privilege. implementations
     * of this will generally use a cached map to determine this that can be refreshed via the {@link #refresh()}
     * function.
     *
     * @param group     the group to search for
     * @param privilege the privilege that needs checking
     * @return whether or not the group has the privilege specified.
     */
    public abstract boolean groupHasPrivilege(@NotNull String group, @NotNull String privilege);

    /**
     * This is used to determine what groups a user belongs to, as it is unwise to cache this sort of information
     * considering that an application's user base may be large,
     * it is advised that implementations of this method perform a call to their underlying datastore (e.g. a direct
     * call to the database) to determine this information.
     *
     *
     * @param principal the unique identifier for the Principal user to search against.
     * @return a list of groups that this user belongs to.
     */
    public abstract List<String> groupsOfUser(@NotNull String principal);

    /**
     * For those that wish to cache their groupPrivilege mapping information, they can override this method for
     * the ability to refresh information.
     */
    public void refresh(){
        //do nothing
    }
}
