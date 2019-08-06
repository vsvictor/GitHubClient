package com.education.githubclient.model

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.databinding.BaseObservable

data class User(val context : Context) : BaseObservable() {
    private val saver : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var email : String? get() { return saver.getString("email","")} set(value) {saver.edit().putString("email", value).apply()}
    var displayName : String? get() { return saver.getString("displayName","")} set(value) {saver.edit().putString("displayName", value).apply()}
    var password : String? get() { return saver.getString("password","")} set(value) {saver.edit().putString("password", value).apply()}
    var token : String? get() { return saver.getString("token","")} set(value) {saver.edit().putString("token", value).apply()}
}