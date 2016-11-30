package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dto.Make;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

import java.util.List;

/**
 * Created by kjensen on 11/29/16.
 */
public interface MakesPromise extends CountablePromise, Promise<List<Make>> {
    MakesPromise state(State state);

    MakesPromise year(int year);

    MakesPromise view(View view);
}
