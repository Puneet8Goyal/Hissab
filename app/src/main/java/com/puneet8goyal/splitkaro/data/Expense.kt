package com.puneet8goyal.splitkaro.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.puneet8goyal.splitkaro.database.Converters

@Entity(
    tableName = "expenses",
    foreignKeys = [
        ForeignKey(
            entity = ExpenseCollection::class,
            parentColumns = ["id"],
            childColumns = ["collectionId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
@TypeConverters(Converters::class)
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val collectionId: Long,
    val description: String,
    val amount: Double,
    val paidByMemberId: Long,
    val splitAmongMemberIds: List<Long>,
    val perPersonAmount: Double,
    val createdAt: Long = System.currentTimeMillis(),
    val isSettled: Boolean = false
)