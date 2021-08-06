package br.com.zup.infrastructure.model

enum class EventType(val event: String) {
    SAVE_PRODUCT("SAVE_PRODUCT"),
    UPDATE_PRODUCT("UPDATE_PRODUCT"),
    DELETE_PRODUCT("DELETE_PRODUCT")
}