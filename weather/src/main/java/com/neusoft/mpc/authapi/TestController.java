package com.neusoft.mpc.authapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author siss
 * @date 2020/8/19  9:33
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/first")
    public ResponseEntity test() {
        List<String> wordList = new ArrayList<>();
        wordList.add("standOne");
        wordList.add("standTwo");
        wordList.add("standThree");

        return ResponseEntity.ok(wordList);
    }

    @GetMapping(value = "/newTest")
    public ResponseEntity test2() {
        return ResponseEntity.ok("success");
    }
}
