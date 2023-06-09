package com.dat.base_compose.data.respository.todo

import com.dat.base_compose.core.common.Resource
import com.dat.base_compose.core.common.flowSafeApiCall
import com.dat.base_compose.core.di.Dispatcher
import com.dat.base_compose.core.di.MyDispatchers
import com.dat.base_compose.data.model.TodoItem
import com.dat.base_compose.data.network.ApiDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TodoRepositoryIml @Inject constructor(
    private val apiDataSource: ApiDataSource,
    @Dispatcher(MyDispatchers.IO) private val dispatcher: CoroutineDispatcher,
) : TodoRepository {
    override fun getTodos(): Flow<Resource<List<TodoItem>>> {
        return flowSafeApiCall(dispatcher) {
            apiDataSource.getTodos()
        }
    }
}
