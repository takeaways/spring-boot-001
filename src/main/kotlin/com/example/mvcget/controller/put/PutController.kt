package com.example.mvcget.controller.put

import com.example.mvcget.model.http.Result
import com.example.mvcget.model.http.UserRequest
import com.example.mvcget.model.http.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PutController {
    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(
        method = [RequestMethod.PUT],
        path = ["/request-mapping"]
    )
    fun requestMapping(): String {
        return "request-mapping - put - method"
    }
    @PutMapping(
        path = ["/put-mapping/object"]
    )
    fun putMappingObject(
        @RequestBody userRequest: UserRequest
    ): UserResponse {
        // 0. Response
        return UserResponse().apply {
            // 1. result
            result = Result().apply {
                    resultCode = "OK"
                    resultMessage = "성공"
            }

            // 2. description
            description = "---------"

            // 3. user
            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest(
                name= "a",
                age = 10,
                email = "jgi0105@Naver.com",
                address = "a address",
                phoneNumber = "010-1111-2222"
            ))
            userList.add(UserRequest(
                name= "a",
                age = 10,
                email = "jgi0105@Naver.com",
                address = "a address",
                phoneNumber = "010-1111-2222",
            ))

            user = userList
        }
    }
}