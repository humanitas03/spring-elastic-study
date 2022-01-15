package com.example.springelasticpratice.entity

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType

@Document(indexName = "users")
class User(
    @Id
    @Field(type = FieldType.Text)
    var id: String?,

    @Field(type = FieldType.Text)
    var name: String,

    @Field(type = FieldType.Integer)
    var age: Int,
)
