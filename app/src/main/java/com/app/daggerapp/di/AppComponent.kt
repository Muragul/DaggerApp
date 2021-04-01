package com.app.daggerapp.di

import android.app.Application
import com.app.daggerapp.di.module.GraphModule
import com.app.daggerapp.di.module.NetworkModule
import com.app.daggerapp.ui.login.LoginFragment
import com.app.daggerapp.ui.login.MainActivity
import com.app.daggerapp.di.module.RepositoryModule
import com.app.daggerapp.di.module.RoomModule
import com.app.daggerapp.ui.apollo.LaunchListActivity
import com.app.daggerapp.ui.list.ListActivity
import com.app.daggerapp.ui.nestedrv.NestedRVActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        GraphModule::class,
        RoomModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(loginFragment: LoginFragment)

    fun inject(listActivity: ListActivity)

    fun inject(launchListActivity: LaunchListActivity)

    fun inject(launchNestedRVActivity: NestedRVActivity)


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun roomModule(roomModule: RoomModule): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent

    }

    companion object {

        fun create(application: Application): AppComponent {
            return DaggerAppComponent.builder()
                .application(application)
                .roomModule(RoomModule(application))
                .networkModule(NetworkModule(application))
                .build()
        }
    }

}