package com.telusko.MySpringAiDemo;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/anthropic")
@CrossOrigin("*")
public class AnthropicAIController {

    /*
    private AnthropicChatModel anthropic;

    public AnthropicAIController(AnthropicChatModel anthropic) {
        this.anthropic = anthropic;
    }
    */

    private ChatClient chatClient;
    public AnthropicAIController(AnthropicChatModel antropic){
        this.chatClient= ChatClient.create(antropic);
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable("message") String message){

        //string response = anthropic.call(message);

        String response = chatClient.prompt(message)
                .system("You respond in a sarcastic, funny and very smart way")
                .call()
                .content();

        return ResponseEntity.ok(response);
    }
}
