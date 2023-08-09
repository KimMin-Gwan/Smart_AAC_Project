package com.example.compass_aac.viewmodel


import androidx.lifecycle.ViewModel
import com.example.data.repository.FindNodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor( private val findNodeRepository: FindNodeRepository) : ViewModel() {

}