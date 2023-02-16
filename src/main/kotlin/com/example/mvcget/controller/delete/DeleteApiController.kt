package com.example.mvcget.controller.delete

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Validated // 빈을 사용하기 위해서 씀
class DeleteApiController {
     //1. path variable
    //2. request param

    @DeleteMapping(path=["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name:String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message="age는 20 보다 커야합니다.")
        @RequestParam age: Int
    ): String {
        val result = "$name $age"
        println(result)
        return result
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        // 이렇게 변경해서 받을 수 도 있다는 예시
        @NotNull
        @Size(min= 2, max=5, message="2~5사이에 길이만 가능함.")
        @PathVariable(value = "name") _name:String,

        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message="age는 20 보다 커야합니다.")
        @PathVariable(name = "age") _age:Int
    ): String {
        val result = "$_name $_age"
        println(result)
        return result
    }

}