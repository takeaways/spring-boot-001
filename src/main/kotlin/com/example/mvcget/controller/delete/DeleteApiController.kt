package com.example.mvcget.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteApiController {
     //1. path variable
    //2. request param

    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name:String,
        @RequestParam age: Int
    ): String {
        val result = "$name $age"
        println(result)
        return result
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        // 이렇게 변경해서 받을 수 도 있다는 예시
        @PathVariable(value = "name") _name:String,
        @PathVariable(name = "age") _age:Int
    ): String {
        val result = "$_name $_age"
        println(result)
        return result
    }

}