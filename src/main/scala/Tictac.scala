import scala.io.StdIn.readLine
import scala.annotation.tailrec

object TicTacToe extends App{

  class TicTac(val player1:Char, val player2:Char, val Move:(Int, Int),
    val Row: (Player, Player, Player),
    val Board : (Row, Row, Row))

  type Player = Char
  type Move = (Int, Int)
  type Row = (Player, Player, Player)
  type Board = (Row, Row, Row)

  val winCases = Set(
    Set((1, 1), (1, 2), (1, 3)),
    Set((2, 1), (2, 2), (2, 3)),
    Set((3, 1), (3, 2), (3, 3)),
    Set((1, 1), (2, 1), (3, 1)),
    Set((1, 2), (2, 2), (3, 2)),
    Set((1, 3), (2, 3), (3, 3)),
    Set((1, 1), (2, 2), (3, 3)),
    Set((1, 3), (2, 2), (3, 1)),
  )

  val default = ' '
  val player1 = 'x'
  val player2 = 'o'

  def main(args: Array[String]) = {
    println("Welcome to TicTacToe!")
    println("To play, enter the row and column of the cell where you want to move when prompted")
    println("Both the row and column must be numbers from 1 to 3")

    runGame()
  }

  def runGame() = {
    @tailrec
    def playRound(board: Board, curr: Player): Option[Player] = {
      printBoard(board)
      println(s"Player $curr's move")
      val move = nextMove(board)
      val newBoard = moveTo(curr, move, board)
      findWinner(newBoard) match {
        case Some(possWinner) => possWinner
        case None             => playRound(newBoard, nextPlayer(curr))
      }
    }

    val startBoard = (
      (default, default, default),
      (default, default, default),
      (default, default, default)
    )

    val winner = playRound(startBoard, player1)
    winner match {
      case Some(player) => println(s"Player $player won!")
      case None         => println("Tie")
    }
  }

  def findWinner(board: Board): Option[Option[Player]] =
    if (isWinner(player1, board)) Some(Some(player1))
    else if (isWinner(player2, board)) Some(Some(player2))
    else if (isTie(board)) Some(None)
    else None

  def moveTo(player: Player, move: Move, board: Board): Board = {
    val (row0, row1, row2) = board
    val (r, c) = move

    def updateTuple[T](tuple: (T, T, T), ind: Int)(f: T => T): (T, T, T) =
      ind match {
        case 1 => tuple.copy(_1 = f(tuple._1))
        case 2 => tuple.copy(_2 = f(tuple._2))
        case 3 => tuple.copy(_3 = f(tuple._3))
      }

    updateTuple(board, r) {
      row => updateTuple(row, c)(_ => player)
    }
  }

  def isWinner(player: Player, board: Board): Boolean =
    winCases.exists(winCase =>
      winCase.forall(move => playerAt(move, board) == player)
    )

  def isTie(board: Board): Boolean = !board.productIterator.exists {
    row => row.asInstanceOf[Row].productIterator.contains(default)
  }

  def playerAt(move: Move, board: Board): Player = {
    val (r, c) = move
    elementAt(elementAt(board, r), c)
  }

  private def elementAt[T](tup: (T, T, T), ind: Int): T =
    ind match {
      case 1 => tup._1
      case 2 => tup._2
      case 3 => tup._3
    }

  @tailrec
  def nextMove(board: Board): Move = {
    val move = (nextRowOrCol("Row"), nextRowOrCol("Column"))

    if (isValid(move, board)) {
      move
    } else {
      println("That move is already taken. Please enter a different move.")
      nextMove(board)
    }
  }

  private def nextRowOrCol(prompt: String): Int = {
    val input = readLine(s"$prompt: ")

    if (input.matches("[1-3]")) {
      input.toInt
    } else {
      println("Please enter a number from 1 to 3")
      nextRowOrCol(prompt)
    }
  }

  def isValid(move: Move, board: Board): Boolean =
    playerAt(move, board) == default

  def nextPlayer(curr: Player): Player =
    if (curr == player1) player2
    else player1

  def printBoard(board: Board): Unit =
    print(
      "__________________\n" +
        tup2String(
          mapTuple(board) {row => tup2String(row, "|")},
          "------\n"
        )
    )

  private def tup2String[T](tup: (T, T, T), sep: String): String =
    s"${tup._1}$sep${tup._2}$sep${tup._3}\n"

  private def mapTuple[T, R](tup: (T, T, T))(f: T => R): (R, R, R) =
    (f(tup._1), f(tup._2), f(tup._3))
}
//var arr = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
//
//def arrayBoard(board:Array[Char]): Unit = {
//  for (rows <- 0 to 2) {
//    for (columns <- 0 to 2) {
//      print(" -|" +board(arr(rows)(columns)) + "|- ")
//    }
//    println()
//
//  }

//
//arr(0) = "X" // neleidzia pakeisti
//
//val startBoard: Array[Char] = ('1' to '9').toArray
//val boardPlay = arrayBoard(startBoard)



//
//val startBoard: Array[Char] = Array('1', '2', '3', '4', '5', '6', '7', '8', '9')
//val patterns: Set[Set[Int]] = Set(
//  Set(0, 1, 2),
//  Set(3, 4, 5),
//  Set(6, 7, 8),
//  Set(0, 3, 6),
//  Set(1, 4, 7),
//  Set(2, 5, 8),
//  Set(0, 4, 8),
//  Set(2, 4, 6)
//)
//
//println("Welcome to the Tic Tac Toe Game!")
//val inputNameOne = readLine("What is your name, Player 1? ")
//val inputXO = readLine("Please choose X or O. ")
//val playerOne = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
//val playerTwo = if (playerOne == "X") "O" else "X"
//println(s"Thank you, $inputNameOne. Your symbol is '$playerOne'.")
//val inputNameTwo = readLine("What is your name, Player 2? ")
//println(s"Thank you, $inputNameTwo. Your symbol is '$playerTwo'.")
//
//printBoard(startBoard)
//nextTurn(startBoard)
//
//def nextTurn(board: Array[Char]): Unit = {
//  val nextMove = readMove(board)
//  board(nextMove) = nextPlayer(board)
//  printBoard(board)
//  if (!isWon(board)) {
//    nextTurn(board)
//  }
//}
//
//def readMove(board: Array[Char]): Int ={
//  try {
//    val inputMove = readLine("Please enter board position number to move. ").toInt-1
//    if(inputMove<0 || inputMove>8 || !board(inputMove).toString.matches("[1-9]")) {
//      throw new Exception
//    }
//    inputMove
//  } catch {
//    case _: Exception => readMove(board)
//  }
//}
//
//def nextPlayer(board: Array[Char]): Char = {
//  val remainingTurns = board.count(_.toString.matches("[1-9]"))
//  if(remainingTurns%2 == 0) playerTwo.toCharArray.head else playerOne.toCharArray.head
//}
//
//def printBoard(board: Array[Char]): Unit = {
//  print(
//    0 to 2 map { r =>
//      0 to 2 map { c =>
//        board(c + r*3)
//      } mkString " | "
//    } mkString ("\n", "\n—   —   —\n", "\n")
//  )
//  println("\nNext Player is " + nextPlayer(board))
//}
//
//def winnerCongrats(board: Array[String]): String = {
//  val remainingTurns = board.count(_.matches("[1-9]"))
//  val winnerName = if(remainingTurns%2 == 0) inputNameOne else inputNameTwo
//  winnerName
//}
//
//def isWon(board: Array[Char]): Boolean = {
//  patterns.foreach(pattern=>{
//    if(pattern.forall(board(_) == board(pattern.head))) {
//      println(s"Winner is ${board(pattern.head)}men! Congratulations!") //TODO winner name cia prideti
//      return true
//    }
//  })
//  false
