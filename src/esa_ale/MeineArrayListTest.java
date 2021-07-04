package esa_ale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/*********************************************************
* @author Kevin Beeskow (s77793@beuth-hochschule.de)	
* @version 1.0, 05/2021
* Einsendeaufgabe ALE-E1 Telefonnummernliste
*********************************************************/

@DisplayName("MeineArrayListTest mit drei unterschiedlichen Testszenarien")
class MeineArrayListTest {

    public MeineArrayList myAL = new MeineArrayList(0, 0);

    @Nested
    @DisplayName("Leeres Array")
    public class MeineArrayListTestLeeresArray {

        @AfterEach
        public void clearList() {
            myAL.clear();
        }

        @Test
        public void testAdd() {

            myAL.add(1);
            myAL.add(2);
            myAL.add(3);
            assertEquals(3, myAL.size());
        }

        @Test
        public void testRemove() {

            assertFalse(myAL.remove(1));
            assertEquals(0, myAL.size());
        }

        @Test
        public void testClear() {
            myAL.clear();
            assertEquals(0, myAL.size());
        }

        @Test
        public void TestToString() {

            assertEquals("", myAL.toString());
        }

    }

    @Nested
    @DisplayName("Ein Eintrag")
    class MeineArrayListTestEinEintrag {

        @BeforeEach

        public void listeFüllen() {
            myAL.add("Hallo");
        }

        @Test
        public void testAdd() {
            myAL.add(1);
            assertEquals(2, myAL.size());
        }

        @Test
        public void testRemove() {

            assertTrue(myAL.remove(0));
            assertEquals(0, myAL.size());
        }

        @Test
        public void testClear() {
            myAL.clear();
            assertEquals(0, myAL.size());
        }

        @Test
        public void TestToString() {

            assertEquals("Hallo", myAL.toString());
        }

    }

    @Nested
    @DisplayName("Mehrere Einträge")
    class MeineArrayListTestMehrereEintraege {

        @BeforeEach
        public void listeFuellen() {
            myAL.add("Hallo");
            myAL.add(2);
            myAL.add('z');
            myAL.add(1.90802);
        }

        @Test
        public void testAdd() {
            myAL.add("fünfter Eintrag");
            assertEquals(5, myAL.size());
        }

        @Test
        public void testRemove() {

            assertTrue(myAL.remove(3));
            assertEquals(3, myAL.size());
        }

        @Test
        public void testClear() {
            myAL.clear();
            assertEquals(0, myAL.size());
        }

        @Test
        public void TestToString() {

            assertEquals("Hallo, 2, z, 1.90802", myAL.toString());
        }
    }
}