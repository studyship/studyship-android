package tsthec.tsstudy.constant

object SignUpRegex {
    const val NICKNAME = "^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$"

    const val EMAIL =
        "[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}"

    const val PASSWORD = "^[A-Za-z0-9]{8,12}\$"

    const val PASSWORD_CHECK = "PASSWORD_CHECK"
}