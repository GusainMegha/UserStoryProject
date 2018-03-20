package ie.flexx.jackanory.domain;

import ie.flexx.jackanory.data.UserStoryData;
import ie.flexx.jackanory.data.UserStoryResearchData;

public class UserStoryResearchImpl implements UserStoryResearch {
    private UserStoryResearchData userStoryResearchData;
    private UserStory userStory;
    private UserStoryRequirement userStoryRequirement;

    /**
     * No argument constructor for UserStoryResearchImpl used when creating an new domain object.
     */
    public UserStoryResearchImpl() {
        userStoryResearchData = new UserStoryResearchData();
    }

    /**
     * Constructor for UserStoryResearchImpl used by JPA
     *
     * @param userStoryResearchData domain retrieved by the database
     */
    public UserStoryResearchImpl(UserStoryResearchData userStoryResearchData) {
        if (userStoryResearchData == null) throw new IllegalArgumentException("userStoryResearchData should not be null.");
        this.userStoryResearchData = userStoryResearchData;
    }

    /**
     * Constructor for UserStoryResearchImpl used when accessing via uniqueManyToOneRelationshipSet to
     * retrieving the children for the userStory
     *
     * @param userStoryResearchData domain child object to be constructed
     * @param userStory             domain parent object
     */
    public UserStoryResearchImpl(UserStoryResearchData userStoryResearchData, UserStory userStory) {
        if (userStoryResearchData == null) throw new IllegalArgumentException("userStoryResearchData should not be null.");
        if (userStory == null) throw new IllegalArgumentException("userStory should not be null.");
        this.userStoryResearchData = userStoryResearchData;
        this.userStory = userStory;
    }

    /**
     * Constructor for UserStoryResearchImpl used when accessing via uniqueManyToOneRelationshipSet to
     * retrieving the children for the userStoryRequirement
     *
     * @param userStoryResearchData domain child object to be constructed
     * @param userStoryRequirement  domain parent object
     */
    public UserStoryResearchImpl(UserStoryResearchData userStoryResearchData, UserStoryRequirement userStoryRequirement) {
        if (userStoryResearchData == null) throw new IllegalArgumentException("userStoryResearchData should not be null.");
        if (userStoryRequirement == null) throw new IllegalArgumentException("userStoryRequirement should not be null.");
        this.userStoryResearchData = userStoryResearchData;
        this.userStoryRequirement = userStoryRequirement;
    }

    @Override
    public Long getId() {
        return getUserStoryResearchData().getId();
    }

    @Override
    public String getDisplayName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Story: ");
        stringBuilder.append("%");
        stringBuilder.append(" ");
        stringBuilder.append(getVersion());
        stringBuilder.append("  (");
        stringBuilder.append(getResearch());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override
    public Long getVersion() {
        return getUserStoryResearchData().getVersion();
    }

    @Override
    public void setVersion(Long version) {
        getUserStoryResearchData().setVersion(version);
    }

    @Override
    public String getResearch() {
        return getUserStoryResearchData().getResearch();
    }

    @Override
    public void setResearch(String research) {
        getUserStoryResearchData().setResearch(research);
    }

    @Override
    public String getSource() {
        return getUserStoryResearchData().getSource();
    }

    @Override
    public void setSource(String source) {
        getUserStoryResearchData().setSource(source);
    }


    public UserStoryResearchData getUserStoryResearchData() {
        return userStoryResearchData;
    }

    @Override
    public UserStory getUserStory() {
        if (userStory == null) {
            UserStoryData userStoryData = getUserStoryResearchData().getUserStoryData();
            if (userStoryData != null) {
                userStory = new UserStoryImpl(userStoryData);
            }
        }
        return userStory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryResearchImpl that = (UserStoryResearchImpl) o;

        if (!userStoryResearchData.equals(that.userStoryResearchData)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userStoryResearchData.hashCode();
    }
}