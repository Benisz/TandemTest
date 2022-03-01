package com.kapmacs.tandemtest.ui.community

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.kapmacs.tandemtest.model.data.Member
import com.kapmacs.tandemtest.model.repo.CommunityProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CommunityViewModel"

@HiltViewModel
class CommunityViewModel @Inject constructor(val repository: CommunityProfileRepository) : ViewModel() {
    fun liked(member: Member) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(member)
        }
    }
    val members: StateFlow<Flow<PagingData<Member>>> = MutableStateFlow(repository.getAllMember())
}
