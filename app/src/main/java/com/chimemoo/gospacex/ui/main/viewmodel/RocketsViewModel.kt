package com.chimemoo.gospacex.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.data.model.Rocket
import com.chimemoo.gospacex.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RocketsViewModel(private val service: ApiService) : ViewModel() {
    private val rockets = MutableLiveData<Resource<List<Rocket>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchRockets()
    }

    private fun fetchRockets() {
        rockets.postValue(Resource.loading(null))
        compositeDisposable.add(
            service.getAllRockets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    rockets.postValue(Resource.success(data))
                }, { throwable ->
                    rockets.postValue(Resource.error("Something wrong!", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getRockets() : LiveData<Resource<List<Rocket>>> {
        return rockets
    }
}