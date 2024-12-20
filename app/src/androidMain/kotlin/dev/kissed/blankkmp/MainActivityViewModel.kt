package dev.kissed.blankkmp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.kissed.blankkmp.data.ImageRepository

class MainActivityViewModel(
    private val imageRepository: ImageRepository,
) : ViewModel() {
    
    private val _states: MutableLiveData<String?> = MutableLiveData(null)
    val states: LiveData<String?> = _states
    
    init {
        _states.postValue(imageRepository.getImageUrl())
    }
    
    class Factory(private val imageRepository: ImageRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                MainActivityViewModel(imageRepository) as T
            } else {
                error("Unknown viewmodel class")
            }
        }
    }
}