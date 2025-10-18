package FamilyTree;

public class Pet implements Identifiable{
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Is a stuffed giraffe";
    }
}
