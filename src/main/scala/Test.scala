
  import scala.annotation.tailrec
  import scala.collection.mutable.ArrayBuffer
  import scala.io.StdIn
  import scala.io.StdIn.readLine
  import scala.language.postfixOps
  import scala.util.{Failure, Random, Success, Try}

  /**
   * A simple expirement in tic tac toe the idea
   * is to try to have something that contains state
   * without having vars.
   */
  object Test extends App {
    //
    //    object Player extends Enumeration {
    //      val X, O = Value
    //    }
    //
    //    val grid: List[Option[Player.Value]] =
    //      None :: None :: None ::
    //        None :: None :: None ::
    //        None :: None :: None ::
    //        Nil
    //
    //    val winningLines = List(0, 1, 2) ::
    //      List(3, 4, 5) ::
    //      List(6, 7, 8) ::
    //      List(0, 3, 6) ::
    //      List(1, 4, 7) ::
    //      List(2, 5, 8) ::
    //      List(1, 4, 8) ::
    //      List(2, 4, 6) :: Nil
    //    @tailrec
    //    def play(next: Player.Value, grid: List[Option[Player.Value]]): String = {
    //      val sliceHorizontal = (g:List[Option[Player.Value]]) =>
    //        g.slice(0, 3) ::
    //          g.slice(3, 6) ::
    //          g.slice(6, 9) :: Nil
    //
    //      val toPrint = (p: Option[Player.Value]) => if (p.isEmpty) "   " else " " + p.get.toString() + " "
    //      val gridPrint = (g: List[List[Option[Player.Value]]]) => g.map(_.map(toPrint).mkString("|")).mkString("\n---+---+---\n")+"\n\n"
    //      println(gridPrint(sliceHorizontal(grid)))
    //
    //      val emptyCells = (g: List[Option[Any]]) => g.zipWithIndex.
    //        filter(_._1.isEmpty).
    //        map(_._2)
    //
    //      lazy val randomCell = Random.shuffle(emptyCells(grid)).head
    //
    //      def playerChoice(g: List[Option[Player.Value]]): Int = {
    //        print("Please enter selection, ")
    //        val result = Try(StdIn.readInt());
    //        result match {
    //          case Success(v) => if (emptyCells(g).contains(v)) v else playerChoice(g)
    //          case Failure(_) => playerChoice(g)
    //        }
    //      }
    //
    //      if (emptyCells(grid).isEmpty) {
    //        "Draw"
    //      } else {
    //        val newGrid = if (next == Player.O) {
    //          grid.updated(randomCell, Some(Player.O))
    //        } else {
    //          grid.updated(playerChoice(grid), Some(Player.X))
    //        }
    //
    //        def listOfDuplicates[A](x: A, length: Int): List[A] = {
    //          if (length < 1) Nil
    //          else x :: listOfDuplicates(x, length - 1)
    //        }
    //
    //        def allEqual[A](first: A, seq: List[A]):Boolean = {
    //          if (seq isEmpty) true
    //          else if (first != seq.head) false
    //          else allEqual(first, seq.tail)
    //        }
    //
    //        //Okay this is very messy not used to this
    //        val hasWon= (p: Player.Value) => winningLines.
    //          foldLeft(false)((i, s) => i || allEqual(Some(p), s.map(newGrid(_))))
    //        if (hasWon(Player.X)) {
    //          println(gridPrint(sliceHorizontal(newGrid)))
    //          "X Wins"
    //        } else if (hasWon(Player.O)) {
    //          println(gridPrint(sliceHorizontal(newGrid)))
    //          "O Wins"
    //        } else play(if (next == Player.O) Player.X else Player.O, newGrid)
    //      }
    //    }
    //
    //    println(play(Player.X, grid))
    //  }
    //
    //
    //    def checkEven(board: Array[Char]): Boolean = {
    //      val remainingTurns = board.count(_.toString.matches("[1-9]"))
    //      if (remainingTurns > 9)
    //        println("It is even !")
    //      return true // else nextTurn(board)
    //
    //    }
    //    val emptyBoard: Array[Char] = Array( '2', '3', '4', '5', '6', '7', '8', '9')
    //    println(checkEven(emptyBoard))
    //  }
    val startingCount=9
    var currentState:Int = startingCount
    val gameEndCondition:Int=0
    println("Welcome to the Tic Tac Toe Game!")
    val inputNameOne = readLine("What is your name, Player 1? ")
    val inputXO = readLine("Please choose X or O. ")
    val playerOne = if (inputXO.toUpperCase == "X") inputXO.toUpperCase else "O"
    val playerTwo = if (playerOne == "X") "O" else "X"
    println(s"Thank you, $inputNameOne. Your symbol is '$playerOne'.")
    val inputNameTwo = readLine("What is your name, Player 2? ") // press ENTER to play with Computer.
    println(s"Thank you, $inputNameTwo. Your symbol is '$playerTwo'.")
    var movesArray: ArrayBuffer[Int] = ArrayBuffer()

    val emptyBoard: Array[Char] = Array('1', '2', '3', '4', '5', '6', '7', '8', '9')
    val winningSets: Set[Set[Int]] = Set(
      Set(0, 1, 2),
      Set(3, 4, 5),
      Set(6, 7, 8),
      Set(0, 3, 6),
      Set(1, 4, 7),
      Set(2, 5, 8),
      Set(0, 4, 8),
      Set(2, 4, 6)
    )

    printBoard(emptyBoard)
    nextTurn(emptyBoard)

    def nextTurn(board: Array[Char]): Unit = {
      val nextMove = moveInput(board)
      board(nextMove) = nextPlayer(board)
      movesArray+=nextMove
      printBoard(board)
      if (!checkWin(board)) {
        nextTurn(board)
      }
      movesArray.toArray
    }
    def printMoves():Array[Int]={
      for ((nextMove, index)<-movesArray.zipWithIndex) {
        val playerName=if (index%2==0) inputNameOne else inputNameTwo
        val move=nextMove+1
        println(s"Move ${index+1}. $playerName took $move")
      }
      movesArray.toArray

    }
    println(printMoves())

    def moveInput(board: Array[Char]): Int = {
      try {
        val inputMove = readLine("Please enter board position number to move. ").toInt - 1
        if (inputMove < 0 || inputMove > 8 || !board(inputMove).toString.matches("[1-9]")) {
          throw new Exception
        }
        inputMove
      } catch {
        case _: Exception => moveInput(board)
//      } catch {
//        case_: Exception
      }
    }
    def gameCount(inputMove:Int): Int={
      val safeMove= inputMove
      currentState-=safeMove
      //movesArray+=safeMove
      currentState
    }

    def nextPlayer(board: Array[Char]): Char = {
      val remainingTurns = board.count(_.toString.matches("[1-9]"))
      val next = if (remainingTurns % 2 == 0) playerTwo.toCharArray.head else playerOne.toCharArray.head
      next
    }

    def isGameActive():Boolean={
      currentState>gameEndCondition
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

    val dbPath = "src/resources/TicTacToeFiles/db/winners.db"
//    val db = new WinnersLosersList(dbPath)
//    db.migrate()

    def checkWin(board: Array[Char]): Boolean = {
      winningSets.foreach(pattern => {
        if (pattern.forall(board(_) == board(pattern.head))) {
          val winnerName = if (board(pattern.head).toString == playerOne) s"$inputNameOne" else s"$inputNameTwo"
          val loserName = if (board(pattern.head).toString == playerOne) s"$inputNameTwo" else s"$inputNameOne"
          //println(s"\nWinner is ${board(pattern.head)}! Congratulations, $winnerName!")
          println(s"\nWinner is $winnerName! Congratulations, $winnerName!")
          println(s"Better luck next time, $loserName!")
          println("\nGame result saved.")
          return true
          //winnerName
         // loserName
        }
      })
      false
      //winnerName
    }

    val winner = "1"
    val loser = "2"
//    db.insertResults(winner, loser)
//
//    db.connection.close()
  }