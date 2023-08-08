package com.marmatsan.core_data.preferences

import androidx.datastore.core.Serializer
import com.marmatsan.core_domain.model.UserInfo
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object UserInfoSerializer : Serializer<UserInfo> {
    override val defaultValue: UserInfo
        get() = UserInfo()

    @Suppress("BlockingMethodInNonBlockingContext") // Actually, it is in a non-blocking context (suspend fun)
    override suspend fun writeTo(t: UserInfo, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = UserInfo.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }

    override suspend fun readFrom(input: InputStream): UserInfo {
        return try {
            Json.decodeFromString(
                deserializer = UserInfo.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }


}