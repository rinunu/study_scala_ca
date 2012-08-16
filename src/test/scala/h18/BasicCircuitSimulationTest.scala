package h18

import org.scalatest.FunSuite
import collection.mutable.ListBuffer

/**
 * 回路 DSL のテストです
 */
class BasicCircuitSimulationTest extends FunSuite {
  // ここで Shift + Command + F10(IDEA の場合) 押すと、テストを実行できます。
  test("テストのテスト") {
    assert(1 === 3)
  }

  /**
   * お試し用デジタル回路シミュレーション！
   *
   * 回路の各ゲートのディレイは回路実装技術によって様々なので、
   * サブクラスで定義します。
   */
  abstract class CircuitSimulation extends BasicCircuitSimulation {

    /**
     * 図18.2 半加算器
     *
     * 基本ゲートから、より複雑なゲートを作る例です
     *
     * テストみてね
     */
    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
      // こんな DSL で、半加算器が作れます
      val d, e = new Wire
      orGate(a, d, e)
      andGate(a, b, c)
      inverter(c, e)
      andGate(d, e, s)
    }

    /**
     * 図18.3 全加算器回路
     *
     * さらに halfAdder を使って、より複雑なゲートを作ってみます
     */
    def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) {
      // TODO 未実装
    }
  }

  /**
   * お試し用！
   */
  class MySimulation() extends CircuitSimulation {
    def InverterDelay: Int = 1

    def AndGateDelay: Int = 3

    def OrGateDelayDelay: Int = 5

    val logs = ListBuffer[String]()

    /**
     * 本にはないですが、テスト用に追加しました。
     *
     * 指定した wire に probe を設定します。
     *
     * この probe は logs にログを出力します
     */
    def logProbe(name: String, wire: Wire) {
      def probeAction() {
        "%s %d new-value = %s".format(name, currentTime, wire.getSignal)
      }
    }
  }

  test("単純な配線") {
    val s = new MySimulation

    val input1, input2, sum, carry = new s.Wire

    s.logProbe("sum", sum)
    // probe 挿入時にアクションが1回実行されるので、
    // ここで出力が表示されます。
    assert(s.logs === Seq("sum 0new-value = false"))
  }

  test("半加算器を使ってみます") {
    // ２個の１桁の２進数を加算できます
  }

  test("全加算器を使ってみます") {
    // ２個の１桁の２進数を加算できます
    // 0+0=0 1+0=1 0+1=1 1+1=10
  }


}
