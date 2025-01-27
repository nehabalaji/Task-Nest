package com.example.data.mappers

import com.example.data.models.DUser
import com.example.domain.models.User


fun User.toDUser() = DUser(uuid, name, email)
fun DUser.toUser() = User(uuid, name, email)