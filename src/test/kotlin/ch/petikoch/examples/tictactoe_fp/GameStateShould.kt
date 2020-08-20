package ch.petikoch.examples.tictactoe_fp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameStateShould {

    @Test
    fun `make player X first`() {
        val gameState = GameState()

        assertEquals(Player.X, gameState.currentPlayer)
    }

}