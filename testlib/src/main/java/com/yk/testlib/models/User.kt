package com.yk.testlib.models

class User {
    var name = "init"
    var pwd = "init"
    var age = 0
    var birthDay = "init"
    var progress = 0

    override fun toString(): String {
        return "User(name='$name', pwd='$pwd', age=$age, birthDay='$birthDay', progress=$progress)"
    }


}