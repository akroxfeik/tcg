package com.arc.tcg.data.model

import com.squareup.moshi.Json

data class CardBriefDetails(
    @Json(name = "category")
    val category: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "illustrator")
    val illustrator: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "localId")
    val localId: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "rarity")
    val rarity: String?,
    @Json(name = "set")
    val set: TCGSet?,
    @Json(name = "variants")
    val variants: TCGVariant?,
    @Json(name = "hp")
    val hp: String?,
    @Json(name = "types")
    val types: List<String>?,
    @Json(name = "evolveFrom")
    val evolveFrom: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "stage")
    val stage: String?,
    @Json(name = "attacks")
    val attacks: List<TCGAttack>?,
    @Json(name = "weaknesses")
    val weaknesses: List<TCGWeakness>?,
    @Json(name = "resistences")
    val resistances: List<TCGWeakness>?,
    @Json(name = "retreat")
    val retreat: Int?,
    @Json(name = "regulationMark")
    val regulationMark: String?,
    @Json(name = "legal")
    val legal: TCGLegal?,
    @Json(name = "updated")
    val updated: String?
)

data class TCGSet(
    @Json(name = "cardCount")
    val cardCount: TCGCardCount?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "logo")
    val logo: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "symbol")
    val symbol: String?
)

data class TCGCardCount(
    @Json(name = "official")
    val official: Int?,
    @Json(name = "total")
    val total: Int?
)

data class TCGVariant(
    @Json(name = "firstEdition")
    val firstEdition: Boolean?,
    @Json(name = "holo")
    val holo: Boolean?,
    @Json(name = "normal")
    val normal: Boolean?,
    @Json(name = "reverse")
    val reverse: Boolean?,
    @Json(name = "wPromo")
    val wPromo: Boolean?
)

data class TCGAttack(
    @Json(name = "cost")
    val cost: List<String>?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "effect")
    val effect: String?,
    @Json(name = "damage")
    val damage: String?
)

data class TCGWeakness(
    @Json(name = "type")
    val type: String?,
    @Json(name = "value")
    val value: String?
)

data class TCGLegal(
    @Json(name = "standard")
    val standard: Boolean?,
    @Json(name = "expanded")
    val expanded: Boolean?
)