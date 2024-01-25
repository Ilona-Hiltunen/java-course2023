package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ObjectExerciseTest {

    // Some test data
    private Person rachel = new Person("Rachel", 28);
    private Person monica = new Person("Monica", 29);
    private Person ross = new Person("Ross", 33);
    private Person phoebe = new Person("Phoebe", 32);
    private Person joey = new Person("Joey", 29);
    private Person chandler = new Person("Chandler", 31);

    // The object we are testing
    private ObjectExercise solution = new ObjectExercise();

    @Test
    void testNameStringWithEmptyList() {
        List<Person> empty = List.of();

        assertEquals("", solution.generateNamesString(empty));
    }

    @Test
    void testNameStringWithTOnePerson() {
        List<Person> onePerson = List.of(rachel);
        assertEquals("Rachel", solution.generateNamesString(onePerson));
    }

    @Test
    void testNameStringWithTwoPeople() {
        List<Person> twoPeople = List.of(rachel, monica);
        assertEquals("Rachel and Monica", solution.generateNamesString(twoPeople));
    }

    @Test
    void testNameStringWithThreePeople() {
        List<Person> threePeople = List.of(rachel, monica, ross);
        assertEquals("Rachel, Monica and Ross", solution.generateNamesString(threePeople));
    }

    @Test
    void testNameStringWithFourPeople() {
        List<Person> fourPeople = List.of(rachel, monica, ross, phoebe);
        assertEquals("Rachel, Monica and 2 others", solution.generateNamesString(fourPeople));
    }

    @Test
    void testNameStringWithSixPeople() {
        List<Person> sixPeople = List.of(rachel, monica, ross, phoebe, joey, chandler);
        assertEquals("Rachel, Monica and 4 others", solution.generateNamesString(sixPeople));
    }
}
