package io.github.kjens93.edmunds;

import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Created by kjensen on 11/23/16.
 */
interface QueryGettable<T> {

    T get();

    Future<T> getAsync(Consumer<T> callback);

    Future<T> getAsync();

}
