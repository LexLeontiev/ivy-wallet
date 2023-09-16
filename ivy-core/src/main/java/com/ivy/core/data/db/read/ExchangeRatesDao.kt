package com.ivy.core.data.db.read

import androidx.room.Dao
import androidx.room.Query
import com.ivy.core.data.db.entity.ExchangeRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeRatesDao {
    @Query("SELECT * FROM exchange_rates")
    fun findAll(): Flow<List<ExchangeRateEntity>>

    @Query("SELECT * FROM exchange_rates WHERE baseCurrency = :baseCurrency AND currency = :currency")
    suspend fun findByBaseCurrencyAndCurrency(
        baseCurrency: String,
        currency: String
    ): ExchangeRateEntity?
}
