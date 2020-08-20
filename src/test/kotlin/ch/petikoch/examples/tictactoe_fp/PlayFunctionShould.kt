package ch.petikoch.examples.tictactoe_fp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayFunctionShould {

    @Test
    fun `make player O second`() {
        val gameState = GameState()

        val resultingGameState = play(gameState, Field.TL)

        assertEquals(Player.O, resultingGameState.currentPlayer)
    }

    @Test
    fun `make players alternate`() {
        val gameState0 = GameState()
        val gameState1 = play(gameState0, Field.TL)

        val resultingGameState = play(gameState1, Field.TM)

        assertEquals(Player.X, resultingGameState.currentPlayer)
    }

    @Test
    fun `make player X win with top row`() {
        val gameState = GameState(
                board = mapOf(
                        Field.TL to Player.X,
                        Field.TM to Player.X,
                        Field.ML to Player.O,
                        Field.MM to Player.O
                ),
                winner = null,
                currentPlayer = Player.X
        )

        val resultingGameState = play(gameState, Field.TR)

        assertThat(resultingGameState).isEqualTo(
                GameState(
                        board = mapOf(
                                Field.TL to Player.X,
                                Field.TM to Player.X,
                                Field.TR to Player.X,
                                Field.ML to Player.O,
                                Field.MM to Player.O
                        ),
                        winner = Player.X,
                        currentPlayer = Player.O
                )
        )
    }

    @Test
    fun `make player O win with top row`() {
        val gameState = GameState(
                board = mapOf(
                        Field.TL to Player.O,
                        Field.TM to Player.O,
                        Field.ML to Player.X,
                        Field.MM to Player.X,
                        Field.BL to Player.X
                ),
                winner = null,
                currentPlayer = Player.O
        )

        val resultingGameState = play(gameState, Field.TR)

        assertThat(resultingGameState).isEqualTo(
                GameState(
                        board = mapOf(
                                Field.TL to Player.O,
                                Field.TM to Player.O,
                                Field.TR to Player.O,
                                Field.ML to Player.X,
                                Field.MM to Player.X,
                                Field.BL to Player.X
                        ),
                        winner = Player.O,
                        currentPlayer = Player.X
                )
        )
    }

    @Test
    fun `make player X win with middle row`() {
        val gameState = GameState(
                board = mapOf(
                        Field.TL to Player.O,
                        Field.TM to Player.O,
                        Field.ML to Player.X,
                        Field.MM to Player.X
                ),
                winner = null,
                currentPlayer = Player.X
        )

        val resultingGameState = play(gameState, Field.MR)

        assertThat(resultingGameState).isEqualTo(
                GameState(
                        board = mapOf(
                                Field.TL to Player.O,
                                Field.TM to Player.O,
                                Field.ML to Player.X,
                                Field.MM to Player.X,
                                Field.MR to Player.X
                        ),
                        winner = Player.X,
                        currentPlayer = Player.O
                )
        )
    }
}