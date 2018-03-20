package ie.flexx.jackanory.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_story_requirement")
public class UserStoryRequirementData implements Serializable {

    private Long id;
    private Long version;
    private String requirement;

    private UserStoryData userStoryData;

    private List<UserStoryResearchData> userStoryResearchDataList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "userStoryRequirementData", targetEntity = UserStoryResearchData.class)
    @OrderColumn(name = "sequence_no")
    public List<UserStoryResearchData> getUserStoryResearchDataList() {
        return userStoryResearchDataList;
    }

    public void setUserStoryResearchDataList(List<UserStoryResearchData> userStoryResearchDataList) {
        this.userStoryResearchDataList = userStoryResearchDataList;
    }

    /**
     * No Attribute Constructor
     */
    public UserStoryRequirementData() {
    }

    /**
     * Required Attribute Constructor
     */
    public UserStoryRequirementData(
            String requirement

    ) {
        this.requirement = requirement;
    }

    @Id
    @Column(name = "user_story_requirement_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Column(name = "requirement", nullable = false)
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_story_id")
    public UserStoryData getUserStoryData() {
        return userStoryData;
    }

    public void setUserStoryData(UserStoryData userStoryData) {
        this.userStoryData = userStoryData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserStoryRequirementData that = (UserStoryRequirementData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }
}
