import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Tree<E extends Person> implements Serializable, TreeData, Iterable<E> {
    private HashSet<E> eData;
    private HashSet<Parent> parentsData;
    

    public E findPersonByName(HashSet<E> inputTree, String nameInput) {
        for (E person : inputTree) {
            if (person.getName().contains(nameInput))
                return person;
        }
        return null;
    }

    public void addPerson(E newPerson) {
        if (newPerson == null)
            return;
        eData.add(newPerson);
    }

    public void removePerson(Integer indexToRemove) {
        eData.removeIf((t) -> t.getId().equals(indexToRemove));
    }

    public void addParent(Integer kidId, Integer parentId) {
        if (kidId != parentId)
            parentsData.add(new Parent(kidId, parentId));
    }

    public HashSet<Integer> findAllKidsId(Integer parentId) {
        HashSet<Integer> kidsIdSet = new HashSet<>();
        for (Parent parentKidPair : parentsData) {
            if (parentId.equals(parentKidPair.getIdParent())) {
                kidsIdSet.add(parentKidPair.getIdKid());
            }
        }
        return kidsIdSet;
    }

    public HashSet<Integer> findAllParentsId(Integer kidId) {
        HashSet<Integer> parentsIdSet = new HashSet<>();
        for (Parent parentKidPair : parentsData) {
            if (kidId.equals(parentKidPair.getIdKid()))
                parentsIdSet.add(kidId);
        }
        return parentsIdSet;
    }

    public HashSet<E> idToPersonSet(HashSet<Integer> inputIdSet) {
        HashSet<E> outSet = new HashSet<>();
        for (E person : eData) {
            if (inputIdSet.contains(person.getId()))
                outSet.add(person);
        }
        return outSet;
    }

    public Tree(HashSet<E> inputPersons, HashSet<Parent> inputParents) {
        this.eData = inputPersons;
        this.parentsData = inputParents;
    }

    public Tree() {
        this(new HashSet<>(), new HashSet<>());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        String prefix = "";
        for (E person : eData) {
            output.append(prefix);
            output.append(person);
            prefix = ", ";
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tree)) {
            return false;
        }
        Tree<E> tree = (Tree) o;
        return Objects.equals(eData, tree.eData) && Objects.equals(parentsData, tree.parentsData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eData, parentsData);
    }

    public HashSet<E> geteData() {
        return eData;
    }

    public void seteData(HashSet<E> personsData) {
        this.eData = personsData;
    }

    public HashSet<Parent> getParentsData() {
        return parentsData;
    }

    public void setParentsData(HashSet<Parent> parentsData) {
        this.parentsData = parentsData;
    }

    public String showAll() {
        StringBuilder outputString = new StringBuilder();
        String prefix = "";
        for (E e : eData) {
            outputString.append(prefix);
            outputString.append(e);
            prefix = "\n";
        }
        return outputString.toString();
    }

    @Override
    public void saveData() {
        SaveFile sf = new SaveFile();
        sf.saveData(this);
    }

    @Override
    public void readData() {
        SaveFile sf = new SaveFile();
        Object dataFromFile = sf.readData();
        if (dataFromFile instanceof Tree) {
            Tree<E> readTree = new Tree<>();
            readTree = (Tree) (dataFromFile);
            this.parentsData = readTree.parentsData;
            this.eData = readTree.eData;
        }
        return;
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<E>(eData);
    }

    public List<E> sortByName(){
        List<E> outList = new ArrayList<E>(eData);
        outList.sort(new PersonComparatorByName());
        return outList;
    }

    public List<E> sortByBirthDate(){
        List<E> outList = new ArrayList<E>(eData);
        outList.sort(new PersonComparatorByBirthDate());
        return outList;
    }
}
