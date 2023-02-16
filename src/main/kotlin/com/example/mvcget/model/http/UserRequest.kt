package com.example.mvcget.model.http

import com.example.mvcget.annotation.StringFormatDateTime
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest (

    @field:NotEmpty
    @field:Size(min = 2, max =8, message = "사이즈 잘 입력하삼~")
    var name:String? = null,

    @field:PositiveOrZero
    var age:Int? = null,

    @field:Email
    var email:String? = null,

    @field:NotBlank
    var address:String?  = null,

//    @JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber:String? = null, //phone_number

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String? = null
){

//    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss")
//    private fun isValidCreatedAt():Boolean{
//        return try {
//            println("createdAt: $createdAt")
//            LocalDateTime.parse(createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//            true
//        }catch (e:Exception){
//            false
//        }
//    }
}

