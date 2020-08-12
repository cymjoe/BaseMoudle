package com.cymjoe.module_work.test

import com.cymjoe.module_work.ui.fragment.work.WorkFragment
import com.cymjoe.module_work.ui.fragment.work.WorkViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { WorkViewModel() }
}

val appModule = listOf(viewModelModule)