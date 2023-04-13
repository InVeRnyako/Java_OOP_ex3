import java.time.Year;

public class Main {
    // Продолжаем грейдить наш проект с гениологическим древом.
    // Изменить древо, сделать класс параметизированным.

    public static void main(String[] args) {
        Tree<Person> testTreeSave = testTree();
        
        testTreeSave.saveData();
        Tree<Person> testTreeRead = new Tree<>();
        testTreeRead.readData();
        // System.out.println(testTreeRead.showAll());
        System.out.println("Список людей сортированный по имени:");
        System.out.println(testTreeRead.sortByName());

        System.out.println("Список людей сортированный по дате рождения:");
        System.out.println(testTreeRead.sortByBirthDate());


    }

    public static Tree<Person> testTree() {
        Tree<Person> testTree = new Tree<>();
        testTree.addPerson(new Person(0, "Михаил Федорович", Year.of(1613), Year.of(1645)));
        testTree.addPerson(new Person(1, "Евдокия Стрешнева"));
        testTree.addPerson(new Person(2, "Мария Милославская"));
        testTree.addPerson(new Person(3, "Алексей Михайлович", Year.of(1645), Year.of(1676)));
        testTree.addParent(3, 0);
        testTree.addParent(3, 1);

        testTree.addPerson(new Person(4, "Наталья Нарышкина"));
        testTree.addPerson(new Person(5, "Федор Алексеевич", Year.of(1676), Year.of(1682)));
        testTree.addParent(5, 2);
        testTree.addParent(5, 3);

        testTree.addPerson(new Person(6, "Иван V", Year.of(1682), Year.of(1696)));
        testTree.addPerson(new Person(7, "Софья Алексеевна", Year.of(1682), Year.of(1689)));
        testTree.addParent(7, 2);
        testTree.addParent(7, 3);

        testTree.addPerson(new Person(8, "Евдокия Лопухина"));
        testTree.addPerson(new Person(9, "Петр I", Year.of(1682), Year.of(1725)));
        testTree.addParent(9, 3);
        testTree.addParent(9, 4);

        return testTree;
    }
}