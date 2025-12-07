package com.asparrin.carlos.poketinder_2025_asparrin

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<PokemonResponse>
)
