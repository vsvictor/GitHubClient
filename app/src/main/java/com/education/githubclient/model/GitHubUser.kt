package com.education.githubclient.model

import com.google.gson.annotations.SerializedName

class GitHubUser {
    @SerializedName("email")
    var email : String? = ""
    @SerializedName("name")
    var displayName : String? = ""
    @SerializedName("login")
    var userName : String? = ""
    @SerializedName("avatar_url")
    var avatar : String? = ""
    @SerializedName("url")
    var url : String? = ""
    @SerializedName("followers_url")
    var followers : String? = ""
    @SerializedName("following_url")
    var following : String? = ""

}