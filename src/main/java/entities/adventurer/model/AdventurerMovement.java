package entities.adventurer.model;

public class AdventurerMovement {

    private AdventurerAction action;
    private Boolean isAlreadyExecuted;

    public AdventurerMovement(AdventurerAction action, Boolean isAlreadyExecuted) {
        this.action = action;
        this.isAlreadyExecuted = isAlreadyExecuted;
    }

    public AdventurerAction getAction() {
        return action;
    }

    public void setAction(AdventurerAction action) {
        this.action = action;
    }

    public Boolean getAlreadyExecuted() {
        return isAlreadyExecuted;
    }

    public void setAlreadyExecuted(Boolean alreadyExecuted) {
        isAlreadyExecuted = alreadyExecuted;
    }
}
