package tower

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.HashMap
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TowerOfHanoiTest {
    private val expectedTower = ArrayDeque<Int>(10)
    private val firstTower = ArrayDeque<Int>(10)
    private val secondTower = ArrayDeque<Int>(10)
    private val thirdTower = ArrayDeque<Int>(10)
    private val towersMap: HashMap<Tower, Deque<Int>>
        get() = HashMap<Tower, Deque<Int>>(10).apply {
            put(Tower.FIRST, firstTower)
            put(Tower.SECOND, secondTower)
            put(Tower.THIRD, thirdTower)
        }

    @BeforeEach
    internal fun setUp() {
        for (disk in 10 downTo 1) {
            firstTower.push(disk)
            expectedTower.push(disk)
        }
    }

    @AfterEach
    internal fun tearDown() {
        firstTower.clear()
        secondTower.clear()
        thirdTower.clear()
    }

    @Test
    internal fun `should move all disks to the 3rd tower in a proper order`() {
        val moveDiskActions = TowerOfHanoiGenerator().generateActionSequence(10)

        for (moveDiskAction in moveDiskActions) {
            val disk = towersMap[moveDiskAction.from]!!.pop()
            towersMap[moveDiskAction.to]!!.push(disk)
        }

        assertTrue { firstTower.isEmpty() }
        assertTrue { secondTower.isEmpty() }
        assertEquals(expectedTower, thirdTower)
    }

    @Test
    internal fun `should move one disk at a time`() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Test
    internal fun `should never put larger disk on the smaller`() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}