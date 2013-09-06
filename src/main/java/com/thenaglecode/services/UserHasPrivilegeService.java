package com.thenaglecode.services;

import javax.annotation.processing.AbstractProcessor;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 1:46 PM
 */
public abstract class UserHasPrivilegeService extends AbstractProcessor {

    private static ServiceLoader<UserHasPrivilegeService> userHasPrivilegeServiceLoader
            = ServiceLoader.load(UserHasPrivilegeService.class);

    public static UserHasPrivilegeService getUserHasPrivilegeService() throws ServiceConfigurationError {
        for(UserHasPrivilegeService service : userHasPrivilegeServiceLoader){
            if(service != null) return service;
        }
        return null;
    }

    public abstract void setUserGroupPrivilegeMappingService(UserGroupPrivilegeMappingService userGroupPrivilegeMappingService);
    public abstract void refreshPrivilegeGroupMap() throws NullPointerException;
    public abstract boolean GroupsHavePrivilege(String privilege, List<String> groups);
}
