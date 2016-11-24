package io.github.kjens93.edmunds;

import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Created by kjensen on 11/23/16.
 */
interface QueryCountable {

    int count();

    Future<Integer> countAsync(Consumer<Integer> callback);

    Future<Integer> countAsync();

}
