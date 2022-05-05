import scala.collection.mutable
import java.nio.file.{Files, Paths}

import java.sql.DriverManager
case class Album(albumID:Int, Title:String, ArtistId:String)
object Day25Album extends App{
  //TODO Create Album Case Class with appropriate data types for each field
  //TODO connect to chinook and extract into Array of Album (using ArrayBuffer to build it up)


  //Extra Challenge
  //TODO save all Tracks into CSV - in src/resources/csv/tracks.csv -
  // results should be very similar or identical to what you get in DBeaver export CSV - tracks_exported.csv

  val dbPath="src/resources/db/chinook.db"
  val url =s"jdbc:sqlite:$dbPath"


  val conn=DriverManager.getConnection(url)
  println(conn.getClientInfo())

  val statement=conn.createStatement()

  val sql=
    """
      |SELECT * FROM albums;
      |""".stripMargin

  val resultSet=statement.executeQuery(sql)
  val metaData=resultSet.getMetaData
  println(s"We have received ${metaData.getColumnCount} columns")

  for (i <- 1 to metaData.getColumnCount) {
    println(s"Column $i is named: ${metaData.getColumnName(i)}")
    println(s"Column $i comes from table: ${metaData.getTableName(i)}")

  }
  val albumBuffer=mutable.ArrayBuffer[Album]()
  while(resultSet.next()){

    for (i <- 1 to metaData.getColumnCount) {

    }
    val album=Album(resultSet.getInt("AlbumId"),resultSet.getString("Title"), resultSet.getString("ArtistId"))
    albumBuffer+=album

    println()
  }
  conn.close()

  val albumCollection=albumBuffer.toArray
  albumCollection.take(20).foreach(println)

  val dstFolder = "src/resources/csv/albums.csv"
  Files.createDirectories(Paths.get(dstFolder))
  val fileName = "albums.csv"
  val dst = s"$dstFolder/$fileName"
  println(s"File $fileName will be save in $dstFolder")
  val text=Util.saveText(dst, albumCollection.mkString("\n"))

}
