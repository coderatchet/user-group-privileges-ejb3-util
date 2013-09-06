package com.thenaglecode.serviceProviders;

import com.thenaglecode.services.UserGroupPrivilegeMappingService;
import com.thenaglecode.services.UserHasPrivilegeService;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.security.DenyAll;
import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 1:47 PM
 * //todo implement
 */
@SupportedAnnotationTypes(value = {
        UserHasPrivilegeServiceProvider.USER_HAS_PRIVILEGE_ANNOTATION,
        UserHasPrivilegeServiceProvider.USER_HAS_PRIVILEGE_ANNOTATION_PLURAL})
public class UserHasPrivilegeServiceProvider extends UserHasPrivilegeService {

    public static final String USER_HAS_PRIVILEGE_ANNOTATION = "com.thenaglecode.annotations.UserHasPrivilege";
    public static final String USER_HAS_PRIVILEGE_ANNOTATION_PLURAL = "com.thenaglecode.annotations.UserHasPrivileges";

    UserGroupPrivilegeMappingService userGroupPrivilegeMappingService;

    public void setUserGroupPrivilegeMappingService(UserGroupPrivilegeMappingService userGroupPrivilegeMappingService) {
        this.userGroupPrivilegeMappingService = userGroupPrivilegeMappingService;
    }

    public void refreshPrivilegeGroupMap() throws NullPointerException {
        if (userGroupPrivilegeMappingService == null) {
            throw new NullPointerException(
                    "userGroupPrivilegeMappingService was null, did you forget to call " +
                            "setUserGroupPrivilegeMappingService(UserGroupPrivilegeMappingService)?");
        }
        userGroupPrivilegeMappingService.refresh();
    }

    public boolean GroupsHavePrivilege(String privilege, List<String> groups) {
        for (String group : groups) {
            if (userGroupPrivilegeMappingService.groupHasPrivilege(group, privilege))
                return true;
        }
        return false;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for(TypeElement annotation : annotations){
            if(annotation.getQualifiedName())
        }
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        UserGroupPrivilegeMappingService service = UserGroupPrivilegeMappingService.getUserGroupPrivilegeMappingService();
        service.refresh();
        setUserGroupPrivilegeMappingService(service);
    }
}
