package ie.flexx.jackanory.domain.dao;

import ie.flexx.jackanory.domain.UserStoryRequirement;

import java.util.List;

public interface UserStoryRequirementDao {
    public UserStoryRequirement createUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public List<UserStoryRequirement> readUserStoryRequirementList();
    //Added this method: Megha
    public UserStoryRequirement readUserStoryRequirement(Long id);

    public UserStoryRequirement updateUserStoryRequirement(UserStoryRequirement userStoryRequirement);

    public void deleteUserStoryRequirement(UserStoryRequirement userStoryRequirement);

}
