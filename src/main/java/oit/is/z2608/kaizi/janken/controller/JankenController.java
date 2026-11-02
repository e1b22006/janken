package oit.is.z2608.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oit.is.z2608.kaizi.janken.model.Janken;

@Controller
public class JankenController {

  @GetMapping("/janken")
  public String janken() {
    return "janken.html";
  }

  @PostMapping("/janken")
  public String jankenPost(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "janken.html";
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String hand, ModelMap model) {
    Janken janken = new Janken(hand);       // model クラスに処理を任せる
    model.addAttribute("janken", janken);   // オブジェクトごと渡せる
    return "janken.html";
  }
}
