package com.example.domain.model

//data class favorite(
//    val id : Long,
//    val sentence: String
//)
data class favorite(val id: Long, val sentence: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as favorite

        if (id != other.id) return false
        if (sentence != other.sentence) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + sentence.hashCode()
        return result
    }
}
