package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testGetAge() {
        var ross = new Person("Ross", 33);

        assertEquals(33, ross.getAge());
    }

    @Test
    void testGetName() {
        var monica = new Person("Monica", 29);

        assertEquals("Monica", monica.getName());
    }

    @Test
    void testToString() {
        var rachel = new Person("Rachel", 28);

        assertEquals("Person [name=Rachel, age=28]", rachel.toString());
    }

    @Test
    void testMakingMultipleObjects() {
        /*
         * This test is not strictly necessary, as the methods in the Person class
         * have been tested in the other tests. The purpose of this test is to
         * verify that you did not accidentally make the fields in the Person class
         * static, which would make all Person objects share the same name and age.
         *
         * But that would be a silly mistake, wouldn't it?
         */
        var ross = new Person("Ross", 33);
        var monica = new Person("Monica", 29);

        assertEquals("Person [name=Ross, age=33]", ross.toString());
        assertEquals("Person [name=Monica, age=29]", monica.toString());
    }
}
