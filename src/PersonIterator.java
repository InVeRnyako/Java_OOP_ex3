import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
    private int index;
    private List<E> personList;
    
    public PersonIterator(List<E> personList){
        this.personList = personList;
    }

    public PersonIterator(HashSet<E> personSet){
        this.personList = new ArrayList<E>(personSet);
    }

    @Override
    public boolean hasNext() {
        return index < personList.size();
    }

    @Override
    public E next() {
        return personList.get(index++);
    }
}
