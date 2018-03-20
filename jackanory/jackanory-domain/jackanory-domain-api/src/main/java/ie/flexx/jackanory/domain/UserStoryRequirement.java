package ie.flexx.jackanory.domain;

public interface UserStoryRequirement {

    public Long getId();

    public String getDisplayName();

    public Long getVersion();

    public void setVersion(Long version);

    public String getRequirement();

    public void setRequirement(String requirement);

    public UserStory getUserStory();

}