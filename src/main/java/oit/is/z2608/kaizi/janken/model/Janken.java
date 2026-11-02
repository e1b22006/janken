package oit.is.z2608.kaizi.janken.model;

public class Janken {
    String result;
    String userHand;
    String cpuHand;

  public Janken(String input) {   // コンストラクタで処理しておく設計の例
    this.userHand = input;
    this.cpuHand = "Gu";
    if (this.userHand.equals("Gu")) {
      this.result = "あいこ";
    } else if (this.userHand.equals("Ch")) {
      this.result = "負け";
    } else if (this.userHand.equals("Pa")) {
      this.result = "勝ち";
    } else {
      this.result = "不正な入力";
    }
  }

  public String getResult() {   // ${janken.result} で参照するために必要
    return this.result;
  }
  public String getUserHand() {   // ${janken.userHand} で参照するために必要
    return this.userHand;
  }
  public String getCpuHand() {   // ${janken.cpuHand} で参照するために必要
    return this.cpuHand;
  }
}