package uz.abbos.dilmurodjonov.todoapp.common.data.retrofit

sealed interface ApiResult<T> {

    /**
     * Represents a network result that successfully received a response containing body data.
     */
    class Success<T>(val data: T) : ApiResult<T>

    /**
     * Represents a network result that successfully received a response containing an error message.
     */
    class Error<T>(val code: Int, val message: String?) : ApiResult<T>

    /**
     * Represents a network result that faced an unexpected exception before getting a response
     * from the network such as [IOException][java.io.IOException] and [UnKnownHostException][java.net.UnknownHostException].
     */
    class Exception<T>(val throwable: Throwable) : ApiResult<T>
}