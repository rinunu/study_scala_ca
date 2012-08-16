package h18

abstract class BasicCircuitSimulation extends Simulation {
  // 後述
  def InverterDelay: Int

  // 後述
  def AndGateDelay: Int

  // 後述
  def OrGateDelayDelay: Int

  /**
   * 配線
   */
  class Wire {
    /**
     * 配線上の現在の信号を返します
     *
     * TODO 未実装
     */
    def getSignal = false

    /**
     * 配線の信号を設定します
     */
    def setSignal(s: Boolean) {
      // TODO 未実装
    }

    /**
     * 配線に Action を追加します
     *
     * アクションは、配線に追加された時に一度されます。
     * また、配線の信号が変わるたびに、すべてのアクションが実行されます。
     */
    def addAction(a: Action) {
      // TODO 未実装
    }
  }

  /**
   * NOT ゲート
   *
   * input 配線にアクションをインストールします
   *
   * このアクションは、アクションがインストールされた時に一度、
   * その後は入力の信号が変わるたびに実行されます。
   *
   * アクションの効果によって、
   * input の信号を反転して output へ設定します
   *
   * ゲートにはディレイがあるので、出力が実際に変更されるのは
   * 入力が変更されてから、 InverterDelay だけ経過した時です。
   */
  def inverter(input: Wire, output: Wire) {
    // TODO 未実装
  }

  /**
   * AND ゲート
   *
   * (ゲートの説明は NOT ゲートを参照してください)
   *
   * a1, a2 の信号の論理積を output へ設定します
   */
  def andGate(a1: Wire, a2: Wire, output: Wire) {
    // TODO 未実装
  }

  /**
   * OR ゲート
   *
   * (ゲートの説明は NOT ゲートを参照してください)
   *
   * o1, o2 の信号の論理和を output へ設定します
   */
  def orGate(o1: Wire, o2: Wire, output: Wire) {
    // TODO 未実装
  }

  /**
   * プローブ(探測器)
   *
   * wire にアクションを設定します。
   *
   * アクションによって配線上の信号の変化をチェックし、
   * 変化した際には標準出力にログを出力します。
   */
  def probe(name: String, wire: Wire) {
    // TODO 未実装
  }

}
