package com.example.mvcget.controller.page

import com.example.mvcget.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody // 사용하면 json으로 떨어짐
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            name= "helo"
        }
    }
}