package h18

/**
 * お試し用デジタル回路シミュレーション！
 *
 * 回路の各ゲートのディレイ(InverterDelay etc.)は回路実装技術によって様々なので、
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
    // TODO 未実装
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
