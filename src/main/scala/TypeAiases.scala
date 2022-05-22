////import scala.io.StdIn.readLine
////import scala.annotation.tailrec
////import scala.util.Random
////
////class TicTacToe:
////object TypeAlises extends App {
////
////  val default = ' '
////  val player1 = 'x'
////  val player2 = 'o'
////  val startBoard = (
////    (default, default, default),
////    (default, default, default),
////    (default, default, default)
////  )
////
////  def __init__(self):{
////    self.board =[]
////  }
////
////
////  def create_board(self:Char): Unit={
////    for (i <-1 in range(3):
////      val row=()
////  }
////    case class InProgress[T](override val board: T) extends Game[T](board)
////    case class Finished[T](override val board: T) extends Game[T](board)
////    case class Broken[T](override val board: T, val problem: String) extends Game[T](board)
////
////    case class Position(x: Int, y: Int)
////    type Board = Seq[Seq[Option[Move]]]
////
////    def createGame(width: Int, height: Int): InProgress[Board] =
////      InProgress(for (x <- 0 until width) yield for(y <- 0 until height) yield None)
////
////  for i in range(3):
////    row
////  =[]
////  for j in range(3):
////    row.append
////  ('-')
////  self.board.append(row)
////
////  def get_random_first_player(self):
////
////  return random.randint(0, 1)
////
////  def fix_spot(self, row, col, player):
////  self.board[row][col] = player
////
////  def is_player_win(self, player):
////  win = None
////
////  n = len(self.board)
////
////  #checking rows
////  for i in range(n):
////    win
////  = True
////  for j in range(n):
////  if self.board[i][j] != player:
////    win
////  = False
////  break
////  if win:
////  return win
////
////  #checking columns
////  for i in range(n):
////    win
////  = True
////  for j in range(n):
////  if self.board[j][i] != player:
////    win
////  = False
////  break
////  if win:
////  return win
////
////  #checking diagonals
////    win = True
////  for i in range(n):
////  if self.board[i][i] != player:
////    win
////  = False
////  break
////  if win:
////  return win
////
////  win = True
////  for i in range(n):
////  if self.board[i][n - 1 - i] != player:
////    win
////  = False
////  break
////  if win:
////  return win
////  return False
////
////  for row in self.board:
////  for item in row:
////  if item == '-':
////  return False
////  return True
////
////  def is_board_filled(self):
////
////  for row in self.board:
////  for item in row:
////  if item == '-':
////  return False
////  return True
////
////  def swap_player_turn(self, player):
////
////  return 'X'
////  if player == 'O' else 'O'
////
////  def show_board(self):
////
////  for row in self.board:
////  for item in row:
////    print
////  (item, end = " ")
////  print()
////
////  def start(self):
////  self.create_board
////
////  ()
////
////  player = 'X'
////  if self.get_random_first_player() == 1 else 'O'
////  while True:
////    print
////  (f"Player {player} turn")
////
////  self.show_board()
////
////  #taking user input
////  row
////  , col = list(
////    map(int, input("Enter row and column numbers to fix spot: ").split()))
////  print()
////
////  #fixing the spot
////  self.fix_spot(row - 1, col - 1, player)
////
////  #checking whether current player is won or not
////  if self.is_player_win(player):
////    print
////  (f"Player {player} wins the game!")
////  break
////
////  //checking whether the game is draw or not
////  if self.is_board_filled():
////    print
////  ("Match Draw!")
////  break
////
////  //swapping the turn
////  player = self.swap_player_turn(player)
////
////  // showing the final view of board
////  print()
////  self.show_board()
////
////
////  /// starting the game
////  tic_tac_toe = TicTacToe()
////  tic_tac_toe.start()
////}
//object TypeAiases extends App {
//  def arrayBoard(): Unit = {
//    val arr = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8))
//    for (rows <- 0 to 2) {
//      for (columns <- 0 to 2) {
//        print(" " + arr(rows)(columns))
//      }
//      println()
//    }
//  }
//  println(arrayBoard())
//}