package jp.co.developersb.controller.chapter3_controller;

import jp.co.developersb.dto.chapter3_dto.CalcForm;
import jp.co.developersb.dto.chapter3_dto.UserForm;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter3-exercise")
public class ExerciseController3 {
    /*
     3-1.Controller 練習問題用コード
    */

    /* -- no5_@RestController 練習問題1 --*/
    // 例: http://localhost:8080/chapter3-exercise/message
    @GetMapping("/message")
    public String message() {
        return "タピオカミルクティ";
    }

    /* -- no9_@RequestParam 練習問題2 --*/
    // 例: http://localhost:8080/chapter3-exercise/drink?name=coffee&size=L
    @GetMapping("/drink")
    public String drink(
            @RequestParam(required = true) String name,
            @RequestParam(required = false, defaultValue = "M") String size) {
        return name + "の" + size + "サイズですね。";
    }

    /* -- no12_DTO 練習問題3 --*/
    // 例: http://localhost:8080/chapter3-exercise/calc-dto?a=3&b=4
    @GetMapping("/calc-dto")
    public String calcDto(CalcForm form) {
        int a = form.a();
        int b = form.b();
        int result = a * b;
        return a + " * " + b  + "は" + result + "になります。";
    }

    /* -- no15_バリデーション 練習問題4 --*/
    // 例: http://localhost:8080/chapter3-exercise/user-valid?id=aaaa&password=bbbbbbbb
    @GetMapping("/user-valid")
    public String user(@Valid UserForm form, BindingResult br) {
        if (br.hasErrors()) {
            return "IDまたはパスワードを正しく設定してください。";
        }
        return "ログインに成功しました！";
    }

}

