package com.thenaglecode.serviceProviders;

import com.thenaglecode.services.UserGroupPrivilegeMappingService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jxnagl
 * Date: 6/09/13
 * Time: 5:33 PM
 * //todo implement
 */
public class UserGroupPrivilegeMappingServiceProvider extends UserGroupPrivilegeMappingService {

    private static List<String> TEST_GROUP_LIST = new ArrayList<>();

    static {
        TEST_GROUP_LIST.add("silly");
    }

    @Override
    public boolean groupHasPrivilege(String group, String privilege) {
        return "silly".equals(group) && "anything".equals(privilege);
    }

    @Override
    public List<String> groupsOfUser(@NotNull String principal) {
        if("someone".equals(principal)) return TEST_GROUP_LIST;
        else return new ArrayList<String>();
    }

    @Override
    public void refresh() {
        //do nothing
    }
}
