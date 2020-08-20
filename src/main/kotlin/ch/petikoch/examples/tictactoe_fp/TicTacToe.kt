package ch.petikoch.examples.tictactoe_fp

import ch.petikoch.examples.tictactoe_fp.Field.*

fun main() {
    var gameState = GameState()                 // "store"
    while (gameState.winner == null && !gameState.board.values.any { it == null }) {
        println(gameState)                      // "view"
        val textInput = readLine()
        val field = convertTextInput(textInput) // "action"
        gameState = play(gameState, field)      // "reduce"
    }
    println(gameState)
}

private fun convertTextInput(textInput: String?): Field {
    return Field.values().find { it.name == textInput }!!
}

fun play(gameState: GameState, field: Field): GameState {
    val newBoard = gameState.board.plus(field to gameState.currentPlayer)
    return GameState(
            currentPlayer = gameState.currentPlayer.other(),
            board = newBoard,
            winner = findWinner(newBoard)
    )
}

private fun findWinner(newBoard: Map<Field, Player?>): Player? {
    return winningConditions.firstOrNull { areSame(newBoard, it) }?.let { newBoard[it.first] }
}

private val winningConditions: List<Triple<Field, Field, Field>> = listOf(
        Triple(TL, TM, TR),
        Triple(ML, MM, MR)
        // ...
)

private fun areSame(board: Map<Field, Player?>,
                    triple: Triple<Field, Field, Field>): Boolean {
    return board[triple.first] == board[triple.second] &&
            board[triple.first] == board[triple.third]
}

data class GameState(
        val currentPlayer: Player = Player.X,
        val board: Map<Field, Player?> = mapOf(),
        val winner: Player? = null
)

enum class Player {
    X, O;

    fun other(): Player = if (this == X) O else X
}

enum class Field {
    TL, TM, TR,
    ML, MM, MR,
    BL, BM, BR
}



