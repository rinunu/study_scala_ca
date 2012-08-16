package h18

import org.scalatest.FunSuite

/**
 * 回路 DSL のテストです
 */
class BasicCircuitSimulationTest extends FunSuite {

  // ここで Shift + Command + F10(IDEA の場合) 押すと、テストを実行できます。

  /**
   * お試し用！
   */
  class TestSimulation() extends CircuitSimulation with TestProbe {
    def InverterDelay: Int = 1

    def AndGateDelay: Int = 3

    def OrGateDelay: Int = 5
  }

  test("wire の信号を設定してみます") {
    val s = new TestSimulation
    val a = new s.Wire
    assert(!a.getSignal, "初期値は false")

    a setSignal true
    assert(a.getSignal, "true を設定してみた")
  }

  test("probe で wire を測定してみます") {
    val s = new TestSimulation

    val wire0 = new s.Wire

    s logProbe("wire0", wire0) // テスト用に、ここでは logProbe を使います
    // つけたタイミングで probe が出力します
    s checkLog "wire0 0 new-value = false"

    // wire の信号を変えてみます
    wire0 setSignal true
    s checkLog "wire0 0 new-value = true"

    // wire の信号が変わらない場合は、何も出力されません
    wire0 setSignal true
    s.checkLog()
  }

  test("AND ゲート を使ってみます") {
    val s = new TestSimulation

    val in0, in1, out = new s.Wire
    s andGate(in0, in1, out)
    s logProbe("out", out)
    s checkLog "out 0 new-value = false"

    // 入力を設定して、 run
    in0 setSignal true
    in1 setSignal true
    s.run()
    s checkLog "out 3 new-value = true"

    in0 setSignal true
    in1 setSignal false
    s.run()
    s checkLog "out 6 new-value = false"
  }

  test("半加算器を使ってみます") {
    // 2個の1桁の2進数を加算できます
    // carry は桁上りの有無です

    def test(signal1: Boolean, signal2: Boolean,
             expectedSum: Boolean, expectedCarry: Boolean) {
      val s = new TestSimulation
      val input1, input2, sum, carry = new s.Wire
      s logProbe("sum", sum)
      s checkLog "sum 0 new-value = false"

      s logProbe("carry", carry)
      s checkLog "carry 0 new-value = false"

      s halfAdder(input1, input2, sum, carry)
      input1 setSignal signal1
      input2 setSignal signal2
      s.run()

      assert(sum.getSignal === expectedSum)
      assert(carry.getSignal === expectedCarry)
    }

    test(false, false, false, false)
    test(true, false, true, false)
    test(false, true, true, false)
    test(true, true, false, true)
  }
}
