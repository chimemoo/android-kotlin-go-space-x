package com.chimemoo.gospacex.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.data.model.Launch
import com.chimemoo.gospacex.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LaunchesViewModel(private val service: ApiService) : ViewModel() {
    private val launches = MutableLiveData<Resource<List<Launch>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchLaunches()
    }

    private fun fetchLaunches() {
        launches.postValue(Resource.loading(null))
        compositeDisposable.add(
            service.getAllLaunches()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    launches.postValue(Resource.success(data))
                }, { throwable ->
                    launches.postValue(Resource.error("Something error!", null))
                })
        )
    }

    fun getAllLaunches(): LiveData<Resource<List<Launch>>> {
        return launches
    }
}