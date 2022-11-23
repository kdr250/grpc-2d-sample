package com.example.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class GreetClientController {

  private final GreetClientService greetClientService;

  public GreetClientController(GreetClientService greetClientService) {
    this.greetClientService = greetClientService;
  }

  @GetMapping
  public String greeting(@RequestParam("name") String name) {
    return greetClientService.receiveGreeting(name);
  }
}
