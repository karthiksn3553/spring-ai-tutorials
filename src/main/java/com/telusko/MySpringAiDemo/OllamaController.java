package com.telusko.MySpringAiDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ollama")
@CrossOrigin("*")
public class OllamaController {

    private ChatClient chatClient;
    public OllamaController(OllamaChatModel ollama){
        this.chatClient= ChatClient.create(ollama);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable("message") String message){

        //string response = anthropic.call(message);

        String response = chatClient.prompt(message)
                .system("You respond in a highly sarcastic, super funny, witty, horny, boys-talk way")
                .call()
                .content();   //get the response in string format

        return ResponseEntity.ok(response);
    }
}
