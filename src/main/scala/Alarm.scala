import java.util.Date

import twitter4j._

import scala.sys.process.Process
/**
  * Created by aokabi on 2017/06/14.
  */
object Alarm {
  def main(args: Array[String]): Unit = {
    val tf = new TwitterFactory()
    val twitter = tf.getInstance()
    
    // TwitterStreamインスタンス
    val twitterStream = new TwitterStreamFactory().getInstance()
    val listener = new StatusListener() {
      override def onStallWarning(warning: StallWarning) = ???
  
      override def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) = ???
  
      override def onScrubGeo(userId: Long, upToStatusId: Long) = ???
  
      override def onStatus(status: Status) = {
        if (status.getUser().getScreenName() == "kujak58" | status.getUser().getScreenName() == "aokabit")
          {
            if (status.getText.contains("alarm")) {
              twitter.updateStatus(s"Ring Ding Dong ${new Date()}")
              Process("sudo mplayer alarm.m4a") !
              //TODO 途中で止める方法を考える
            }
          }
      }
  
      override def onTrackLimitationNotice(numberOfLimitedStatuses: Int) = ???
  
      override def onException(ex: Exception) = {
        ex.printStackTrace()
      }
    }
    // リスナ
    twitterStream.addListener(listener)
    twitterStream.filter("@aokabit")
  }
}
