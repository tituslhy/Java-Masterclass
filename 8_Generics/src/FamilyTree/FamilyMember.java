package FamilyTree;

public abstract class FamilyMember implements Identifiable{
    protected String name;
    protected int age;
    protected Relation relation;

    public FamilyMember(String name, int age, Relation relation) {
        this.age = age;
        this.name = name;
        this.relation = relation;
    }

    public abstract String favoriteActivity();

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRelation() {
        return switch(relation){
            case MUM -> "MUM";
            case DAUGHTER -> "DAUGHTER";
            default -> "DAD";
        };
    }

    @Override
    public String toString() {
        return "NAME: %s | AGE: %d | RELATION: %s |".formatted(
                getName(), getAge(), getRelation()
        );
    }
}

class Dad extends FamilyMember{

    public Dad(String name, int age) {
        super(name, age, Relation.DAD);
    }

    @Override
    public String favoriteActivity() {
        return "Sleeping. Needs more sleep because of daughters.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Is a father learning how to code in Java.";
    }

    @Override
    public String toString(){
        return super.toString() + "| DESCRIPTION: %s ".formatted(getDescription());
    }
}

class Mum extends FamilyMember{

    public Mum(String name, int age) {
        super(name, age, Relation.MUM);
    }

    @Override
    public String favoriteActivity() {
        return "Playing with her daughters.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Is a mummy to two beautiful girls.";
    }

    @Override
    public String toString(){
        return super.toString() + "| DESCRIPTION: %s ".formatted(getDescription());
    }
}

class Daughter extends FamilyMember{

    public Daughter(String name, int age) {
        super(name, age, Relation.DAUGHTER);
    }

    @Override
    public String favoriteActivity() {
        return "Playing with papa and mama";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Enjoys jumping on daddy";
    }

    @Override
    public String toString(){
        return super.toString() + "| DESCRIPTION: %s ".formatted(getDescription());
    }
}