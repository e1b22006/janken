package oit.is.z0000.lec02.janken.model;

public class Janken {
  private String playerHand;
  private String cpuHand;
  private String result;

  public Janken(String playerHand) {
    this.playerHand = playerHand;
    this.cpuHand = "Gu"; // CPUは常にグー
    this.result = judge(playerHand, cpuHand);
  }

  private String judge(String player, String cpu) {
    if (player.equals(cpu)) {
      return "あいこ";
    }
    if ((player.equals("Gu") && cpu.equals("Choki"))
        || (player.equals("Choki") && cpu.equals("Pa"))
        || (player.equals("Pa") && cpu.equals("Gu"))) {
      return "勝ち";
    }
    return "負け";
  }

  // 英語の値を日本語の表示に変換する
  private String toJapanese(String hand) {
    switch (hand) {
      case "Gu":    return "グー";
      case "Choki": return "チョキ";
      case "Pa":    return "パー";
      default:      return "不明";
    }
  }

  // Thymeleafから ${janken.playerHand} などで参照するためのgetter
  public String getPlayerHand() {
    return toJapanese(playerHand);
  }

  public String getCpuHand() {
    return toJapanese(cpuHand);
  }

  public String getResult() {
    return result;
  }
}