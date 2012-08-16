package h18

import org.scalatest.FunSuite

/**
 * この trait は Scala 本にはないですが、テスト用に追加しました。
 *
 * 実装は気にしないでくださいませ。。
 */
trait TestProbe extends BasicCircuitSimulation with FunSuite {
  private var _logs = List[String]()

  /**
   * ログを取得し、クリアします
   */
  def popLogs() = {
    val l = _logs
    _logs = List.empty
    l.reverse
  }

  /**
   * 指定した wire に probe を設定します。
   *
   * この probe は logs にログを出力します
   */
  def logProbe(name: String, wire: Wire) {
    def probeAction() {
      val log = "%s %d new-value = %s".format(name, currentTime, wire.getSignal)
      println(log)
      _logs = log :: _logs
    }

    wire addAction probeAction
  }

  def checkLog(expected: String*) {
    assert(popLogs() === expected)
  }

}
