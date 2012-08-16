package h18

/**
 * シミュレーションの具現クラスは、このクラスを継承します。
 */
abstract class Simulation {
  /**
   * Action は「引数 0, 戻り値なしの関数」の別名です
   *
   * (type メンバーと言います)
   */
  type Action = () => Unit


  /**
   * シミュレーション上の現在時間を表します
   */
  def currentTime: Int = curtime

  private var curtime = 0

  /**
   * 作業項目
   *
   * 指定された time に action を実行するものです。
   *
   * (case class にすることで、 time, action 用のアクセッサーが自動定義されます。
   * WorkItem は Simulation の入れ子クラスです)
   */
  case class WorkItem(time: Int, action: Action)

  /**
   * 作業項目のアジェンダ
   *
   * WorkItem(いつ、なにを行うか) の作業リストです。
   */
  private var agenda: List[WorkItem] = List()

  /**
   * agenda に項目を追加します
   *
   * currentTime から delay 時間後にアクションを実行するよう
   * agenda にアクションを挿入します。
   *
   * (block は 処理の名前渡しです。
   * block という名前で関数オブジェクトを受け取るのと、ほぼ同義です。
   * 呼び出し方はテストを見てみてください。
   *
   * ()() と引数リストが2つあります。
   * これはカリー化というものです。
   * ここでは、テストに書いてあるような呼び出し方をしたいため、カリー化しています。
   * )
   */
  def afterDelay(delay: Int)(block: => Unit) {
    // TODO 未実装
  }

  /**
   * agenda から先頭項目を取り除いて実行するという作業を繰り返します。
   */
  def run() {
    // TODO 未実装
  }
}
