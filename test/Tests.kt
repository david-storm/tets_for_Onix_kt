import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Tests {

    @Test
    fun constructor() {
        assertEquals("test1", myString("test1").toString())
        assertEquals("", myString("").toString())
        assertEquals("1234", myString(1234).toString())
    }

    @Test
    fun concat() {
        assertEquals("hello world", myString("hello").concat(myString(" world")).toString())
        assertEquals("Onix-best", myString("best").concat(myString("Onix-"), false).toString())
        assertEquals("test1", myString("test1").concat(myString("")).toString())
        assertEquals("test2", myString("").concat(myString("test2")).toString())
    }


    @Test
    fun substring() {
        assertEquals("123", myString("123456789").substr(3).toString())
        assertEquals("456789", myString("123456789").substr(6, 3).toString())
        assertEquals("456", myString("123456789").substr(3,3).toString())
        assertEquals("", myString("123456789").substr(0).toString())
    }

    @Test
    fun find() {
        assertEquals(-1, myString("test1").find(myString("2")))
        assertEquals(1, myString("test1").find(myString("e")))
        assertEquals(0, myString("test1").find(myString("test")))
        assertEquals(-1, myString("test1").find(myString("test11")))
        assertEquals(4, myString("test1").find(myString(1)))
    }

  @Test
    fun toFloat() {
        assertEquals(1f, myString("1").toFloat())
        assertEquals(0f, myString("test").toFloat())
        assertEquals(2.5f, myString("2.5").toFloat())
        assertEquals(11.87f, myString("11.87test").toFloat())
        assertEquals(0f, myString("").toFloat())

    }
}
