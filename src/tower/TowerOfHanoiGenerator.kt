package tower

import tower.Tower.*
import tower.action.MoveDiskAction
import java.util.*

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
