package by.iba.gleb.List;

import java.util.ArrayList;
import java.util.List;
public class ListService {

    private static List<Person> groupList = new ArrayList<>();

    static {
        groupList.add(new Person("Aliaksandr", "+375296234877", "avkavalchuk@gmail.com"));
        groupList.add(new Person("Iryna", "+375296553367", "iryna@gmail.com"));
        groupList.add(new Person("Vladimir", "+375296234877", "borbuh@gmail.com"));
    }

    static public void addPerson(Person person) {
        groupList.add(new Person(person));
    }


    static public List<Person> retrieveList() {
        return groupList;
    }
}

