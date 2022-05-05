import scala.collection.mutable
import java.nio.file.{Files, Paths}

import java.sql.DriverManager
case class Tracks(TrackID:Int, Name:String,
                 AlbumId:Int, MediaTypeId:String,
                  GenreId:Int, Composer:String,  Milliseconds:Int,
                  Bytes:Int, UnitPrice:Int)

object Day25Tracks extends App {
  //TODO Create Track Case Class
  //TODO connect to database and extract into Array of Tracks -

  //Extra Challenge
  //TODO save all Tracks into CSV - in src/resources/csv/tracks.csv -
  // results should be very similar or identical to what you get in DBeaver export CSV - tracks_exported.csv
  //Check Day 20 examples on how we did this
  val dbPath = "src/resources/db/chinook.db"
  val url = s"jdbc:sqlite:$dbPath"


  val conn = DriverManager.getConnection(url)
  println(conn.getClientInfo())

  val statement = conn.createStatement()
  val sql =
    """
      |SELECT * FROM tracks;
      |""".stripMargin
  val resultSet = statement.executeQuery(sql)
  val metaData = resultSet.getMetaData
  println(s"We have received ${metaData.getColumnCount} columns")

  for (i <- 1 to metaData.getColumnCount) {
    println(s"Column $i is named: ${metaData.getColumnName(i)}")
    println(s"Column $i comes from table: ${metaData.getTableName(i)}")
  }
  val trackBuffer=mutable.ArrayBuffer[Tracks]()
  while(resultSet.next()){

  val tracks=Tracks(resultSet.getInt("TrackID"),
      resultSet.getString("Name"),
      resultSet.getInt("AlbumId"),
      resultSet.getString("MediaTypeId"),
      resultSet.getInt("GenreId"),resultSet.getString("Composer"),
      resultSet.getInt("Milliseconds"),
      resultSet.getInt("Bytes"),
      resultSet.getInt("UnitPrice"))

    trackBuffer+=tracks
    println()
  }
  conn.close()
  val trackCollection=trackBuffer.toArray
  trackCollection.take(20).foreach(println)
  val dstFolder = "src/resources/csv/tracks.csv"
  Files.createDirectories(Paths.get(dstFolder))
  val fileName = "tracks.csv"
  val dst = s"$dstFolder/$fileName"
  println(s"File $fileName will be save in $dstFolder")
  val text=Util.saveText(dst, trackCollection.mkString("\n"))

}
