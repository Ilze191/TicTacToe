import scala.io.StdIn.readLine

/**
 * provides values and variables needed for the game
 */
package object tictactoe {
  val playerXsymbol = 'X'
  val playerOsymbol = 'O'
  val playerXName = readLine(s"You will be player X. What is your name? ")
  val playerOName = readLine(s"You will be player O. What is your name? ")
  val winningCombo = Array((0,1,2), (3,4,5), (6,7,8), //Horizontal
                            (0,3,6), (1,4,7), (2,5,8), //Vertical
                            (0,4,8), (2,4,6)) //Diagonal
  val initialBoardNumbers = Array('1', '2', '3', '4', '5', '6', '7', '8','9')
  var boardNumbers = Array('1', '2', '3', '4', '5', '6', '7', '8','9')
  var response = "yes"
}

