package uz.ttpu.coroutinepractice

// Builder	        Return Value	Blocks Thread?	Waits for Children?
// launch	        Job	            No	            Yes (itself via .join())
// async	        Deferred<T>	    No	            Yes (itself via .await())
// runBlocking	    T (result)	    Yes	            Yes
// coroutineScope	T (result)	    No	            Yes
// withContext	    T (result)	    No	            Yes