////import io.Source
////import scala.util.control.Breaks._
////
/////**
//// * Scala TicTacToe game without any side effects
//// */
////object TicTacToe {
////  val WinCount = 3
////
////  sealed trait Move
////  case object O extends Move
////  case object X extends Move
////
////  sealed abstract class Game[T](val board: T)
////  case class InProgress[T](override val board: T) extends Game[T](board)
////  case class Finished[T](override val board: T) extends Game[T](board)
////  case class Broken[T](override val board: T, val problem: String) extends Game[T](board)
////
////  case class Position(x: Int, y: Int)
////  type Board = Seq[Seq[Option[Move]]]
////
////  def createGame(width: Int, height: Int): InProgress[Board] =
////    InProgress(for (x <- 0 until width) yield for(y <- 0 until height) yield None)
////
////  def move(game: InProgress[Board], p: Position): Game[Board] =
////    (game.board(p.x)(p.y), placeMove(game.board, p, whoseTurn(game))) match {
////      case (Some(move),  board) => Broken(board, "Position was already taken by " + move)
////      case (None, board) if finished_?(board) => Finished(board)
////      case (None, board)  => InProgress(board)
////    }
////
////  def whoseTurn(game: InProgress[Board]): Move =
////    game.board.flatMap(_.flatten).foldLeft((0, 0)) {
////      case ((x, o), X) => (x + 1, o)
////      case ((x, o), O) => (x, o + 1)
////    } match {
////      case (x, o) if x - o <= 0 => X
////      case _ => O
////    }
////
////  def whoWon(game: Finished[Board]): Option[Move] =
////    (for {
////      x <- 0 until game.board.size
////      y <- 0 until game.board(0).size
////      curr <- game.board(x)(y)
////      if won_?(game.board, curr, x, y)
////    } yield Some(curr)) find (_.isDefined) getOrElse None
////
////  def playerAt(game: Game[Board], p: Position): Option[Move] = game.board(p.x)(p.y)
////
////  def draw(game: Game[Board]) = (for (y <- 0 until game.board(0).size) yield horizMoves(game.board, 0, y) map {
////    case Some(m) => m.toString
////    case None => " "
////  } mkString " | ") mkString ("\n" + ("-" * game.board.size).mkString("-+-") + "\n")
////
////  private def won_?(board: Board, m: Move, x: Int, y: Int): Boolean =
////    won_?(horizMoves(board, x, y), m) || won_?(vertMoves(board, x, y), m) ||
////      won_?(diagRightMoves(board, x, y), m) || won_?(diagRightMoves(board, x, y), m)
////
////  private def won_?(moves: Seq[Option[Move]], m: Move): Boolean = moves.foldLeft(List(0)) {
////    case (count :: rest, Some(`m`)) => count + 1 :: rest
////    case (counts, _) => 0 :: counts
////  }.max >= WinCount
////
////  private def horizMoves(board: Board, x: Int, y: Int) = for (xx <- x until board.size) yield board(xx)(y)
////  private def vertMoves(board: Board, x: Int, y: Int) = for (yy <- y until board(x).size) yield board(x)(yy)
////  private def diagRightMoves(board: Board, x: Int, y: Int) =
////    for ((xx, yy) <- (x until board.size) zip (y until board(x).size)) yield board(xx)(yy)
////  private def diagLeftMoves(board: Board, x: Int, y: Int) =
////    for ((xx, yy) <- (0 to x by -1) zip (y until board(x).size)) yield board(xx)(yy)
////
////  private def placeMove(board: Board, p: Position, m: Move) =
////    board.updated(p.x, board(p.x).updated(p.y, Some(m)))
////
////  private def finished_?(board: Board) =
////    board.flatMap(_.flatten).size == board.size * board(0).size || whoWon(Finished(board)).isDefined
////}
////
////object Int {
////  def unapply(s: String): Option[Int] = try {
////    Some(s.toInt)
////  } catch {
////    case _ : java.lang.NumberFormatException => None
////  }
////}
////
////object TicTacToeGame extends App {
////  import TicTacToe._
////
////  val game = createGame(3, 3)
////
////  println("Welcome to Tic Tac Toe!")
////  prompt(game)
////
////  breakable {
////    Source.stdin.getLines.map(_.split("\\s*,\\s*").toList match {
////      case List(Int(x), Int(y)) if x < 3 && y < 3 => Some(Position(x, y))
////      case _ => println("Invalid position, should be: x, y"); None
////    }).filter(_.isDefined).map(_.get).foldLeft(game: Game[Board]) {
////      case (g @ InProgress(_), p) =>
////        move(g, p) match {
////          case game @ InProgress(_) => prompt(game)
////          case game @ Broken(_, problem) => print("Problem: " + problem); prompt(g)
////          case game @ Finished(_) =>
////            println(draw(game) + "\n" + "Game finished, " + whoWon(game) + " won!"); break; game
////        }
////      case _ => println("Wrong state!"); game
////    }
////  }
////
////  println("Bye!")
////
////  def prompt(game: InProgress[Board]): InProgress[Board] = {
////    print("\n" + draw(game) + "\n" + whoseTurn(game) + "> ");
////    game
////  }
////}
//import scala.annotation.tailrec
//import scala.io.StdIn.readLine
//class TicTacToe(
//                 val playerOne:String,
//                 val playerTwo: String,
//                 var movesArray: Array[Int] = Array(), // accumulates players moves, that later need to match with winning
//                 var isPlayerATurn:Boolean = true)
////                 var currentState:Int = startingCount
////                 var currentPlayer:String = if (isPlayerATurn) playerOne else playerTwo
////                 var movesArray: ArrayBuffer[Int] = ArrayBuffer()
//object TicTacToeOld extends App{
//    val playerOne = 'x'
//    val playerTwo = 'o'
//  val startBoard: Array[Char] = ('1' to '9').toArray
//  val patterns: Set[Set[Int]] = Set(
//    Set(0, 1, 2),
//    Set(3, 4, 5),
//    Set(6, 7, 8),
//    Set(0, 3, 6),
//    Set(1, 4, 7),
//    Set(2, 5, 8),
//    Set(0, 4, 8),
//    Set(2, 4, 6)
//  )
//
////  def main(args: Array[String]): Unit = {
//   startGame()
////  }
//
//  def startGame(): Unit ={
//    println("Welcome to TicTacToe!")
//    println("To play, enter the number on the board where you want to play")
//    printBoard(startBoard)
//    nextTurn(startBoard)
//  }
//
//  @tailrec
//  private def nextTurn(board: Array[Char]): Unit = {
//    val nextMove = readMove(board)
//    board(nextMove) = nextPlayer(board)
//    printBoard(board)
//    if (!isWon(board)) {
//      nextTurn(board)
//    }
//  }
//
//  @tailrec
// def readMove(board: Array[Char]): Int = {
//    val input = readLine("Input next Turn: ")
//    if (input.matches("[1-9]")) {
//      val move = input.toInt - 1
//
//      if (board(move).isDigit) {
//        move
//      } else {
//        println("That location is already taken.")
//        readMove(board)
//      }
//    } else {
//      println("The input must be an integer between 1 and 9.")
//      readMove(board)
//    }
//  }
//
//  private def nextPlayer(board: Array[Char]): Char = {
//    val remainingMoves = board.count(_.toString.matches("[1-9]"))
//    if(remainingMoves%2 == 0) playerOne else playerTwo //'x' else 'o'
//  }
//
//  private def printBoard(board: Array[Char]): Unit = {
//    println(
//      board.grouped(3)
//        .map(_.mkString("|"))
//        .mkString("__________\n", "\n------\n", "")
//    )
//    println(s"Next Player is ... ${nextPlayer(board)}")
//  }
//
////  def isWon(movesArray: Array[Char]): Boolean = {
////    val i=movesArray
////    //val i=board
////    i match {
////      case Array(0, 1, 2)  => println("Winner !Congrats !")
////      case Array(3, 4, 5)  => println("Winner !Congrats !")
////      case Array(6, 7, 8)  => println("Winner !Congrats !")
////      case Array(0, 3, 6)  => println("Winner !Congrats !")
////      case Array(1, 4, 7)  => println("Winner !Congrats !")
////      case Array(2, 5, 8) => println("Winner !Congrats !")
////      case Array(0, 4, 8) => println("Winner !Congrats !")
////      case Array(2, 4, 6) => println("Winner !Congrats !")
////
////        //case _ => println("Hmmm...")
////        return true
////    }
////    false
////  }
//  private def isWon(board: Array[Char]): Boolean = {
//    patterns.foreach(pattern => {
//      if (pattern.forall   (board(_) == board(pattern.head)) ) {
//        print("Winner is " + board(pattern.head))
//        return true
//      }
//    })
//    false
//  }
//}