package com.example.mvcget.controller.get

import com.example.mvcget.model.http.UserRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController // REST API Controller 동작
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path= ["/hello", "/abc"])
    fun hello():String{
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path=["/request-mapping"]) //예전에 사용하던 방법
    fun requestMapping(): String {
        return "request-mapping"
    }
    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name:String, @PathVariable age:Int): String {
        println("$name , $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name:String, @PathVariable(name = "age") age:Int): String {

        val name = "kotlin"

        println("$_name , $age")
        return "$_name $age"
    }
    @GetMapping("/get-mapping/query-param") // ?name=ss&age=22
    fun queryParam(
        @RequestParam name:String,
        @RequestParam(value = "age") age:Int
    ): String {
        val result = "$name , $age"
        println(result)
        return result
    }

    // name, age, address, email
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map:Map<String, Any>): Map<String, Any> {
        println(map)
        val phoneNumber= map["phone-number"];
        println("my phone number is $phoneNumber")

        return map
    }

}