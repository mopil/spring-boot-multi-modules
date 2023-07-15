package com.example.multiserver.exception

enum class ErrorType(val message: String) {
    BAD_REQUEST("잘못된 요청입니다."),
    NOT_FOUND("존재하지 않는 정보 입니다."),
    ETC_UNKNOWN_ERROR("정의 되지 않은 에러"),
    UNAUTHORIZED("미인증"),
    ACCESS_DENIED("권한이 없습니다."),
}
