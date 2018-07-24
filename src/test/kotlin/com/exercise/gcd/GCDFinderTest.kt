import com.exercise.gcd.GCDFinder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GCDFinderTest{
    @Test
    internal fun `should return 3 given 3 and 6`() {
        assertEquals(3, GCDFinder().find(3,6))
    }
    
    @Test
    internal fun `should return 12 given 12 and 24`() {
        assertEquals(12, GCDFinder().find(12,24))
    }

    @Test
    internal fun `should return 1 given 13 and 25`() {
        assertEquals(1, GCDFinder().find(13,25))
    }

    @Test
    internal fun `should return 40 given 3400 and 360`() {
        assertEquals(40, GCDFinder().find(3400,360))
    }
}