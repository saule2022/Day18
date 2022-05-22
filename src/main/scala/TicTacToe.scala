//import scala.io.StdIn.readLine
////
////object TicTacToe extends App{
////  def print_tic_tac_toe(values:Int): Unit={
////    //val x=1
////    //val values=for (x <- 9){
////    println("\n")
////    println("\t     |     |")
////    println ("\t  {}  |  {}  |  {}".format(values[0], values[1], values[2])) //format([0], [1], [2]))
////    println ("\t_____|_____|_____")
////    println ("\t     |     |")
////    println ("\t  {}  |  {}  |  {}".format(values[3], values[4], values[5])) //([3], [4], [5]))
////    println ("\t     |     |")
////
////    println ("\t  {}  |  {}  |  {}".format(values[6], values[7], values[8]))
////    println ("\t     |     |")
////    println ("\n")
////
////  }
////  val x=1
////  //var values=for (1 <- 9) {
////  //println(print_tic_tac_toe())
////  println(print_tic_tac_toe(  " "*(for (x <- 9))))
////
//////var x=1
//////var values=for (x <- 9) {
//////   print_tic_tac_toe(values)
////// }
////
////}
//////print_tic_tac_toe(values = [' ' for x in range(9)])
//////println(print_tic_tac_toe(' ' for x in range(9))
////println("Welcome to the Tic Tac Toe Game!")
////val inputNameOne = readLine("What is your name, Player 1? ")
////val inputXO = readLine("Please choose X or O. ")
////val inputNameTwo = readLine("What is your name, Player 2? ")
////
//object TicTacToe extends App {
//
//
////  val playerOne: String = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
////  val playerTwo: String = if (playerOne == "X") "O" else "X"
////
////  println(s"Thank you, $inputNameTwo. Your symbol is $playerTwo.")
////  print("Let's start the game!")
////  println("\n")
//
// // var arr = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
//  def isWinner(movesArray: Array[Char]): Boolean = {
//    val i=movesArray
//    i match {
//     // case 0 | 1 | 2   => println("Winner !Congrats !")
//      case Array(3, 4, 5)  => println("Winner !Congrats !")
////      case Array(6, 7, 8)  => println("Winner !Congrats !")
////      case Array(0, 3, 6)  => println("Winner !Congrats !")
////      case Array(1, 4, 7)  => println("Winner !Congrats !")
////      case Array(2, 5, 8) => println("Winner !Congrats !")
////      case Array(0, 4, 8) => println("Winner !Congrats !")
////      case Array(2, 4, 6) => println("Winner !Congrats !")
//
//        case _ => println("Hmmm...")
//        return true
//    }
//    false
//  }
//  val movesArray: Array[Char] = Array[Char](3, 4, 5 )
//  println(isWinner(movesArray))
////  def arrayBoard(board: Array[Char]): Unit = {
////    for (rows <- 0 to 2) {
////      for (columns <- 0 to 2) {
////        print(" -|" + board(arr(rows)(columns)) + "|- ")
////      }
////      println()
////    }
////  }
////
////  val startBoard: Array[Char] = ('1' to '9').toArray
////  val board2 = arrayBoard(startBoard)
////
////  def moveInput(board: Array[Char]): Int = {
////    val input = readLine("Enter your chosen position number, between 1 and 9: ")
////    if (input.matches("[1-9]")) {
////      val move = input.toInt //  input.toInt - 1
////      if (board(move).isDigit) {
////        move
////      } else {
////        println("That position is already taken.")
////        moveInput(board)
////      }
////    } else {
////      println("Your choice must be an integer between 1 and 9.")
////      moveInput(board)
////    }
////  }
////
////  def itsDraw(board: Array[Char]): Boolean = {
////    val i = board
////    i match {
////    if (board.isDigit)
////    return false
////    }
////    true
////  }
//}
////var currentPlayer = playerOne
////
////def changePlayer() = {
////  if (currentPlayer == playerOne) currentPlayer = playerTwo
////  else
////    currentPlayer = playerOne