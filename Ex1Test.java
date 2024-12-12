import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);
            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() //tests the function int2Number
        {
            assertEquals("1011b2"  ,Ex1.int2Number(11, 2 ));
            assertEquals("1104b5"  ,Ex1.int2Number(154, 5 ));
            assertEquals("13AAbG"  ,Ex1.int2Number(5034, 16 ));
            assertEquals("500bE"  ,Ex1.int2Number(980, 14 ));
            assertEquals("6A35bB"  ,Ex1.int2Number(9234, 11 ));
            assertEquals("827"  ,Ex1.int2Number(827, 10 ));
        }
        @Test
        void maxIndexTest()//tests the function maxIndex
        {
            assertEquals(4, Ex1.maxIndex(new String[] {"1", "2", "3", "4"}));
            assertEquals(20398 , Ex1.maxIndex(new String[] {"21bG", "32bA", "234234b6", "5134"}));
            assertEquals(1795687 , Ex1.maxIndex(new String[] {"2345", "2345b6", "12312121213b4", "3465bE"}));
            assertEquals(6057968, Ex1.maxIndex(new String[] {"234bB", "76868", "12352865b9", "3235"}));
            assertEquals(14519232, Ex1.maxIndex(new String[] {"2345b6", "924875bA", "8217572bB", "2451"}));
            assertEquals(435436, Ex1.maxIndex(new String[] {"435436", "2134bE", "6234b7", "2346b8"}));
            assertEquals(0, Ex1.maxIndex(new String[] {"234095b9", "234b5", "2523523", "4334"}));//because on of the elements in the array are not in the format therefor it's the max is 0
        }
    @Test
    void equalsTest() //tests the function equals
    {
        assertTrue(Ex1.equals("1011b2","11"));
        assertTrue(Ex1.equals("980","500bE"));
        assertTrue(Ex1.equals("1104b5","154bA"));
        assertFalse(Ex1.equals("ABCbG","441234"));
        assertFalse(Ex1.equals("1023sdf4b2","444"));
        assertFalse(Ex1.equals("2342341sdf","444"));
        assertFalse(Ex1.equals("123bA","1238bF"));
    }
    @Test
    void ConverterTest()//tests the function Converter
    {
        assertEquals(11, Ex1.Converter('B'));
        assertEquals(12, Ex1.Converter('C'));
        assertEquals(10, Ex1.Converter('A'));
        assertEquals(5, Ex1.Converter('5'));
        assertEquals(14, Ex1.Converter('E'));
    }
}
