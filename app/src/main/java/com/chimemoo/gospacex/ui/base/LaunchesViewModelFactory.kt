package com.chimemoo.gospacex.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.ui.main.viewmodel.LaunchesViewModel

class LaunchesViewModelFactory(private val apiService: ApiService): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LaunchesViewModel::class.java)) {
            return LaunchesViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}