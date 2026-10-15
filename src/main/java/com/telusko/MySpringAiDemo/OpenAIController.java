package com.telusko.MySpringAiDemo;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class OpenAIController {

    private OpenAiChatModel openai;

    public OpenAIController(OpenAiChatModel openai) {
        this.openai = openai;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable("message") String message){
        String response = openai.call(message);

        return ResponseEntity.ok(response);
    }
}
