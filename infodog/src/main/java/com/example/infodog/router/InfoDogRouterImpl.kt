package com.example.infodog.router

import android.content.Context
import android.content.Intent
import com.example.infodog.ui.MainActivity

class InfoDogRouterImpl : InfoDogRouter {

    override fun goToInfoDog(context: Context) {
        context.startActivity(Intent(context, MainActivity::class.java))
    }
}