package com.example.dummydictionary.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "word_table")

data class Word(
    @PrimaryKey @ColumnInfo(name = "term") @SerializedName("term") val term: String,
    @ColumnInfo(name = "definition") @SerializedName("description") val definition: String,
    @ColumnInfo(name = "is_fav", defaultValue = "0")  var isFav: Boolean
)

@Entity(tableName = "antonym_table", primaryKeys = ["term", "antonym_term"])

data class Antonym(
    @ColumnInfo(name = "term") val term: String,
    @ColumnInfo(name = "antonym_term") val synonymTerm: String
)

@Entity(tableName = "synonym_table", primaryKeys = ["term", "synonym_term"])
data class Synonym(
    @ColumnInfo(name = "term") val term: String,
    @ColumnInfo(name = "synonym_term")val synonymTerm: String
)