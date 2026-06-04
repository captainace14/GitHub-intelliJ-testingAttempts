package unitTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HousekeepingAssignments {
    private StringBuffer textBuffer;

    @BeforeEach
    public void setup(){
        //must be declared beacuse it will be assigned to its default value null everytime
        textBuffer = new StringBuffer();
        textBuffer.append("START:");
    }
    @AfterEach
    public void tearDown(){
        textBuffer = null;
    }

    @Test
    public void testBufferAppend(){
        //CAREFUL WITH CONVERTING TO THE SAME DATA TYPES !!!!!!!
        textBuffer.append("THIS IS A TEST");
        assertEquals("START:THIS IS A TEST", textBuffer.toString());
    }
    @Test
    public void testStringBufferandString_areNotTheSameDataTypes(){
        textBuffer.append("THIS IS A TEST");
        assertNotEquals("START:THIS IS A TEST", textBuffer);
    }


    @Test
    public void testBufferLength(){
      assertEquals(6, textBuffer.length());

      textBuffer.append("newWords");
      assertEquals(14, textBuffer.length());
    }

    @Test
    public void testBufferClear(){
        textBuffer.setLength(0);
        assertEquals(0, textBuffer.length());
    }


    //We didn't assigned the textBuffer toString(), how did sub understood and converted StringBuffer into String?
    @Test
    public void testBufferSubstring(){
        String sub = textBuffer.substring(0,5);
        assertEquals("START", sub);
    }


}
