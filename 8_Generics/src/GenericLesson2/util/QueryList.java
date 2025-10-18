package GenericLesson2.util;

import GenericLesson2.Student;

import java.util.ArrayList;
import java.util.List;

/*
The class must be the first on the extended list
QueryList only takes in a type that is of Student and implements QueryItem
 */
public class QueryList <T extends Student & QueryItem>{
    private List<T> items;

    public QueryList(List<T> items){
        this.items = items;
    }

    /*
    This is how to define a static generic method on a generic class
    Always add the generic type first before the return type. This "S"
    is not the same as the "T" of the generic class. You can change this
    to any alphabet.
     */
    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
        List<S> matches = new ArrayList<>();
        for (var item: items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value){
        List<T> matches = new ArrayList<>();
        for (var item: items){
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
