//import scala.collection.mutable.ArrayBuffer
//import scala.io.StdIn.readLine
//
////
////import scala.io.StdIn.readLine
////import scala.annotation.tailrec
////
////object TicTacToe2 {
////
////  type Player = Char
////  type Coord = (Int, Int)
////  type Move = (Coord, Player)
////
////  val winCases: Set[Set[Coord]] = Set(
////    Set((1, 1), (1, 2), (1, 3)),
////    Set((2, 1), (2, 2), (2, 3)),
////    Set((3, 1), (3, 2), (3, 3)),
////    Set((1, 1), (2, 1), (3, 1)),
////    Set((1, 2), (2, 2), (3, 2)),
////    Set((1, 3), (2, 3), (3, 3)),
////    Set((1, 1), (2, 2), (3, 3)),
////    Set((1, 3), (2, 2), (3, 1))
////  )
////
////  val default = ' '
////  val player1 = 'x'
////  val player2 = 'o'
////
////  def main(args: Array[String]) = {
////    println("Welcome to TicTacToe!")
////    println(
////      "To play, enter the row and column of the cell where you want to move when prompted"
////    )
////    println("Both the row and column must be numbers from 1 to 3")
////    printBoard(List.empty)
////
////    runGame()
////  }
////
////  def runGame() = {
////    @tailrec
////    def playRound(moves: List[Move], curr: Player): Option[Player] = {
////      println(s"Player $curr's move")
////      val move = (nextMove(moves), curr)
////      val newMoves = move :: moves
////      printBoard(newMoves)
////      findWinner(newMoves) match {
////        case Some(possWinner) => possWinner
////        case None             => playRound(newMoves, nextPlayer(curr))
////      }
////    }
////
////    val winner = playRound(List.empty, player1)
////    winner match {
////      case Some(player) => println(s"Player $player won!")
////      case None         => println("Tie")
////    }
////  }
////
////  def findWinner(board: Board): Option[Option[Player]] =
////    if (isWinner(player1, board)) Some(Some(player1))
////    else if (isWinner(player2, board)) Some(Some(player2))
////    else if (isTie(board)) Some(None)
////    else None
////
////  def isWinner(player: Player, moves: List[Move]): Boolean =
////    winCases.exists { winCase =>
////      winCase.forall(move => playerAt(move, moves) == player)
////    }
////
////  def isTie(moves: List[Move]): Boolean = moves.size == 9
////
////  def playerAt(coord: Coord, moves: List[Move]): Player =
////    moves.find(move => move._1 == coord).map(_._2).getOrElse(default)
////
////  @tailrec
////  def nextMove(moves: List[Move]): Coord = {
////    val coord = (nextRowOrCol("Row"), nextRowOrCol("Column"))
////
////    if (isValid(coord, moves)) {
////      coord
////    } else {
////      println("That move is already taken. Please enter a different move.")
////      nextMove(moves)
////    }
////  }
////
////  private def nextRowOrCol(prompt: String): Int = {
////    val input = readLine(s"$prompt: ")
////
////    if (input.matches("[1-3]")) {
////      input.toInt
////    } else {
////      println("Please enter a number from 1 to 3")
////      nextRowOrCol(prompt)
////    }
////  }
////
////  def isValid(coord: Coord, moves: List[Move]): Boolean =
////    playerAt(coord, moves) == default
////
////  def nextPlayer(curr: Player): Player =
////    if (curr == player1) player2
////    else player1
////
////  def printBoard(moves: List[Move]): Unit =
////    print(
////      1 to 3 map { r =>
////        1 to 3 map { c =>
////          playerAt((r, c), moves)
////        } mkString "|"
////      } mkString ("__________\n", "\n------\n", "\n")
////    )
////}
////object createGame extends App {
////  def randomName(names: Seq[String]): String = {
////    val randomNum = util.Random.nextInt(names.length)
////    names(randomNum)
////  }
////
////  val names = Seq("Aleka", "Christina", "Tyler", "Molly")
////  val winner = randomName(names)
////  println(winner)
class TicTacToe(
                 val playerOne:String,
                 val playerTwo: String,
                 var movesArray: Array[Int] = Array(), // accumulates players moves, that later need to match with winning
                 var isPlayerATurn:Boolean = true)
//                 var currentState:Int = startingCount
//                 var currentPlayer:String = if (isPlayerATurn) playerOne else playerTwo
//                 var movesArray: ArrayBuffer[Int] = ArrayBuffer()
object AssignmentTicTacToeGame extends App {
//
//    // 1. creating board (define rows, define columns; check
//    // all available move options (for player one and for player two)
//    // 2. loop - player moves (take input, define move, check move against options, check state, create new set / announce win)
//    // 3. game ends - add results to database, clean up
//
//    //intro
//    println("\nWelcome to the Tic Tac Toe Game!\n")
//    val inputName = readLine("What is your name, Player 1? ")
//    val inputXO = readLine("Please choose X or O. ")
////
////    val playerOne: String = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
////    val playerTwo: String = if (playerOne == "X") "O" else "X"
////    val startingSymbol = " — "
////
////    println(s"Thank you, $inputName. Your symbol is '$playerOne'.")
////
////    def startingBoard: Unit = {
////      println(startingSymbol + startingSymbol + startingSymbol)
////      println(startingSymbol + startingSymbol + startingSymbol)
////      println(startingSymbol + startingSymbol + startingSymbol)
////    }
////
////    startingBoard
////
////    val inputMove = readLine("Please enter row number and column number. ")
////    val playerOneMoveRow = inputMove.charAt(0)
////    val playerOneMoveColumn = inputMove.charAt(1)
////
////    val position = "r" + playerOneMoveRow + "c" + playerOneMoveColumn
////  }
////val default = ' '
////  val player1 = 'x'
////  val player2 = 'o'
//
////  val playerOne: String = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
////  val playerTwo: String = if (playerOne == "X") "O" else "X"
//
////  println(s"Thank you, $inputNameTwo. Your symbol is $playerTwo.")
////  //print("Let's start the game!")
////  println("\n")
////  var currentPlayer:String = if (isPlayerATurn) playerOne else playerTwo
//  var movesArray: Array[Int] = Array() // accumulates players moves, that later need to match with winning
//  val playerOne = 'x'
//  val playerTwo = 'o'
//  var arr = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
//  //val moveInput=readLine("please enter the number:").toInt
//  val startBoard: Array[Char] = ('1' to '9').toArray
//  val board2=(arrayBoard(startBoard))
//
//  gameStart()
//  def gameStart():Unit= {
//    println ("Let's start TicTacToe Game !")
//    println ("To play, enter the number on the board where you want to play")
//    arrayBoard (startBoard)
//    nextTurn (startBoard)
//}
//  def nextTurn(board: Array[Char]): Unit = {
//    val nextMove = moveInput(board)
//    board(nextMove) = changePlayer(board)
//    //movesArray+=nextMove.toInt
//    arrayBoard(board)
//    if (!isWinner(board)) {
//      nextTurn(board)
//    }
//  }
//
  def moveInput(board: Array[Char]): Int = {
    val input = readLine("Enter your chosen position number, between 1 and 9: ")
    if (input.matches("[1-9]")) {
      val move = input.toInt //  input.toInt - 1
      movesArray+=move
      if (board(move).isDigit) {
        move
      } else {
        println("That position is already taken.")
        moveInput(board)
      }
    } else {
      println("Your choice must be an integer between 1 and 9.")
      moveInput(board)
    }
  }
//  def changePlayer(board: Array[Char]): Char = {
//    val remainingMoves = board.count(_.toString.matches("[1-9]"))
//    if(remainingMoves%2 == 0) playerOne else playerTwo //'x' else 'o'
//  }
//
//  //  def changePlayer():Unit = {
//  //    if (currentPlayer == playerOne) currentPlayer = playerTwo
//  //    else
//  //      currentPlayer = playerOne
//
//  def arrayBoard(board:Array[Char]): Unit = {
//  //var arr = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
//    for (rows <- 0 to 2) {
//     for (columns <- 0 to 2) {
//       print(" -|" +board(arr(rows)(columns)) + "|- ")
//    }
//    println()
//  }
//    println(s" Player ${changePlayer(board)} turn! ")
//}
////  val startBoard: Array[Char] = ('1' to '9').toArray
////  val board2=(arrayBoard(startBoard))
////println(board2)
//
//  println(moveInput(startBoard))
//
//  //println(nextPlayer())
//  //var currentPlayer = playerOne
//
//  println(changePlayer(startBoard))
//  println(movesArray.mkString)
//
//  def isWinner(movesArray: Array[Char]): Boolean = {
//    val i=movesArray
//    //val i=board
//    i match {
//      case Array(0, 1, 2)  => println("Winner !Congrats, current player !")
//      case Array(3, 4, 5)  => println("Winner !Congrats !")
//      case Array(6, 7, 8)  => println("Winner !Congrats !")
//      case Array(0, 3, 6)  => println("Winner !Congrats !")
//      case Array(1, 4, 7)  => println("Winner !Congrats !")
//      case Array(2, 5, 8) => println("Winner !Congrats !")
//      case Array(0, 4, 8) => println("Winner !Congrats !")
//      case Array(2, 4, 6) => println("Winner !Congrats !")
//
//      //case _ => println("Hmmm...")
//        return true
//    }
//    false
//  }
//
//}
//
//
//
//
//
//
//
