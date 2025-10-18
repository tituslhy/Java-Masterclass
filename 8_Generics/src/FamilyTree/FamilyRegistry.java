package FamilyTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FamilyRegistry <T extends FamilyMember & Identifiable>{
    private List<T> familyMembers;

    public FamilyRegistry(List<T> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void addMember(T member){
        familyMembers.add(member);
    }

    public void printAllMembers(){
        for (var member : familyMembers){
            System.out.println(member.toString());
        }
    }

    public FamilyMember findMemberByRelation(String relation){
        for (var member: familyMembers){
            if (relation.equalsIgnoreCase(member.getRelation())){
                return member;
            }
        }
        return null;
    }

    public static <S extends Identifiable> List<S> filterByName(List<S> members, String name){
        for (var member: members){
            if (name.toLowerCase().equals(member.getName().toLowerCase())){
                var return_ = new ArrayList<>(Arrays.asList(member));
                return return_;
            }
        }
        return new ArrayList<>();
    }
}
