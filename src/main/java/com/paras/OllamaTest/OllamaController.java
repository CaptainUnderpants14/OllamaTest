package com.paras.OllamaTest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Controller
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @GetMapping("/chat")
    public String showResponse() {
        return "chat";
    }

    // Receive Response from Model
    @PostMapping("/chat")
    public String resonse(String prompt, Model model) {
        String rawResponse = ollamaService.getResponse(prompt);
        String cleanResponse = rawResponse.replaceAll("(?s)<think>.*?</think>", "").trim();
        model.addAttribute("prompt", prompt);
        model.addAttribute("answer", cleanResponse);
        return "chat";
    }
}
