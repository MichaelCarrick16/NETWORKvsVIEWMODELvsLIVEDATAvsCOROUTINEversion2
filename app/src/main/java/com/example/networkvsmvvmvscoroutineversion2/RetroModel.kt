package com.example.networkvsmvvmvscoroutineversion2

data class RetroModel(val items : List<ItemModel>)
data class ItemModel(val name : String , val description : String , val owner : OwnerModel)
data class OwnerModel(val avatar_url : String)

