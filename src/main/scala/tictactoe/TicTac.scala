package tictactoe
object TicTac extends App {
  import scala.io.StdIn.readChar

  println("\t\tLET'S PLAY TIC-TAC-TOE!")

  def mainPlay(board: GameBoard, turn: Char) {

    /**
     * Offers a player to pick a number, checks if it's available on the board,
     * if not - re-offers to pick a number
     *
     */
    def clampMove(): Char = {
      print("Choose a number from the board above -> ")
      val validNumbers = board.movesLeft
      val move = readChar
      if (validNumbers.contains(move)) {
        move
      } else {
        println(s"Wrong number! Choose another one from available options")
        clampMove()
      }
    }

    /**
     * @gameStat variable we need in order to break the loop from playAgain function (when player answers N)
     * @playAg another variable we created
     * @return the game board is reset and printed out
     */
    var gameStat = false
    def restartingGame(): Unit = {
      if (board.isGameOver) {
        board.gameOverPrint
        var playAg = board.playAgain()
        if (playAg == true) {
          board.resetBoard
          board.showBoard
          gameStat = false
        } else if (playAg == false) {gameStat = true}
      }
    }

    println
    board.showBoard
    restartingGame()

    if (turn == playerXsymbol && gameStat == false) {
      println("\t  ***  PLAYER X TURN  ***")
      val updatedBoard = board.playerXplays(clampMove)
      mainPlay(updatedBoard, playerOsymbol)
    } else if (gameStat == false) {
      println("\t  ***  PLAYER O TURN  ***")
      val updatedBoard = board.playerOplays(clampMove)
      mainPlay(updatedBoard, playerXsymbol)
    }
  }
  /**
   * Calling the function, player X having the first turn
   */
  mainPlay(new GameBoard(),playerXsymbol)

}
