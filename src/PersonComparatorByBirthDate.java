import java.time.Year;
import java.util.Comparator;

public class PersonComparatorByBirthDate implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        Year dateOne = o1.getBirthYear();
        Year dateTwo = o2.getBirthYear();
        if (dateOne == null)
            dateOne = Year.of(0);
        if (dateTwo == null)
            dateTwo = Year.of(0);
        return dateOne.compareTo(dateTwo);
    }
    
}