package oit.is.z2608.kaizi.janken;
import oit.is.z0000.lec02.janken.model.Janken;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  // GET /janken：直接アクセスされた場合
  @GetMapping("/janken")
  public String janken() {
    return "janken";
  }

  // POST /janken：フォームから名前を受け取る
  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {
    model.addAttribute("name", name);
    return "janken";   // templates/janken.html を表示する
  }

  @GetMapping("/jankengame")
  public String jankengame(@RequestParam String hand, ModelMap model) {
    Janken janken = new Janken(hand);
    model.addAttribute("janken", janken);
    return "janken";
  }
}