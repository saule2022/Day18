import scala.io.StdIn.readLine
import scala.language.postfixOps
import scala.util.control.Breaks.break

object Player extends App {
  println("Welcome to the Tic Tac Toe Game!")
  val inputNameOne = readLine("What is your name, Player 1? ")
  val inputXO = readLine("Please choose X or O. ")
  val playerOne = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
  val playerTwo = if (playerOne == "X") "O" else "X"
  println(s"Thank you, $inputNameOne. Your symbol is '$playerOne'.")
  val inputNameTwo = readLine("What is your name, Player 2? ")
  println(s"Thank you, $inputNameTwo. Your symbol is '$playerTwo'.")

  val emptyBoard: Array[Char] = Array('1', '2', '3', '4', '5', '6', '7', '8', '9')
  val winningSets: Set[Set[Int]] = Set(
    Set(0, 1, 2),
    Set(3, 4, 5),
    Set(6, 7, 8),
    Set(0, 3, 6),
    Set(1, 4, 7),
    Set(2, 5, 8),
    Set(0, 4, 8),
    Set(2, 4, 6),
    //Set(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  )

  printBoard(emptyBoard)
  nextTurn(emptyBoard)

  def nextTurn(board: Array[Char]): Unit = {
    val nextMove = moveInput(board)
    board(nextMove) = nextPlayer(board)
    printBoard(board)
    if (!checkEven(board)) {
    //if (!checkWin(board)) {
      println("Stop")
      //nextTurn(board)
    } else if (!checkWin(board)) {
      //println("Stop")
      nextTurn(board)
    }
  }



  def moveInput(board: Array[Char]): Int = {
    try {
      val inputMove = readLine("Please enter board position number to move. ").toInt - 1
      if (inputMove < 0 || inputMove > 8 || !board(inputMove).toString.matches("[1-9]")) {
        throw new Exception
      }
      inputMove
    } catch {
      case _: Exception => moveInput(board)
    }
  }

  def nextPlayer(board: Array[Char]): Char = {
    val remainingTurns = board.count(_.toString.matches("[1-9]"))
    if (remainingTurns % 2 == 0) playerTwo.toCharArray.head else playerOne.toCharArray.head
  }

  def printBoard(board: Array[Char]): Unit = {
    print(
      0 to 2 map { r =>
        0 to 2 map { c =>
          board(c + r * 3)
        } mkString " | "
      } mkString("\n", "\n—   —   —\n", "\n")
    )
    println("\nNext Player is " + nextPlayer(board))
  }
  def checkEven(board: Array[Char]): Boolean = {
    val remainingTurns = board.count(_.toString.matches("[1-9]"))
    if (remainingTurns <= 9)
      println("It is even !") //break
    return true // else nextTurn(board)
  }

  def checkWin(board: Array[Char]): Boolean = {
    winningSets.foreach(pattern => {
      if (pattern.forall(board(_) == board(pattern.head))) {
        val winnerName = if (board(pattern.head) == playerOne) s"$inputNameTwo" else s"$inputNameOne"
        println(s"\nWinner is ${board(pattern.head)}! Congratulations, $winnerName!")
        return true
      }
    })
    false
  }

}