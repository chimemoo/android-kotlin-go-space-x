package com.chimemoo.gospacex.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chimemoo.gospacex.data.api.ApiService
import com.chimemoo.gospacex.data.model.Launchpad
import com.chimemoo.gospacex.data.model.Launch
import com.chimemoo.gospacex.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UpcomingViewModel(private val service: ApiService) : ViewModel() {
    private val upcomming = MutableLiveData<Resource<Launch>>()
    private val launchpad = MutableLiveData<Resource<Launchpad>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchUpcommingLaunch()
    }

    private fun fetchUpcommingLaunch() {
        upcomming.postValue(Resource.loading(null))
        compositeDisposable.add(
            service.getUpcomingLaunch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    upcomming.postValue(Resource.success(data))
                    fetchLaunchpad(data.launchpad)
                }, { throwable ->
                    upcomming.postValue(Resource.error("Something wrong!", null))
                })
        )
    }

    private fun fetchLaunchpad(id: String?) {
        launchpad.postValue(Resource.loading(null))
        compositeDisposable.add(
            service.getLaunchpad(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    launchpad.postValue(Resource.success(data))
                }, { throwable ->
                    launchpad.postValue(Resource.error("Something when wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getUpcommingLaunch(): LiveData<Resource<Launch>> {
        return upcomming
    }

    fun getLaunchpad(): LiveData<Resource<Launchpad>> {
        return launchpad
    }
}