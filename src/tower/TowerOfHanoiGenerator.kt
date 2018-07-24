package tower

import tower.Tower.*
import tower.action.MoveDiskAction
import java.util.*

/**
 *
The Tower of Hanoi (also called the Tower of Brahma or Lucas' Tower[1] and sometimes pluralized) is a mathematical game or puzzle. It consists of three rods and a number of disks of different sizes, which can slide onto any rod. The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.

The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
No disk may be placed on top of a smaller disk.
 */
class TowerOfHanoiGenerator {

    fun generateActionSequence(numOfDisks: Int):List<MoveDiskAction> {
        if (numOfDisks == 0) return emptyList()
        return move(numOfDisks, FIRST, THIRD, SECOND)
    }

    private fun move(numToMove: Int, source: Tower, destination: Tower, temp: Tower): List<MoveDiskAction> {
        if (numToMove == 1) return listOf(MoveDiskAction(source, destination))

        val actions = LinkedList<MoveDiskAction>()
        actions.addAll(move(numToMove - 1, source, temp, destination))
        actions.add(MoveDiskAction(source, destination))
        actions.addAll(move(numToMove - 1, temp, destination, source))
        return actions
    }

}
