package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dtos.Make;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

/**
 * Created by kjensen on 11/29/16.
 */
public interface MakePromise extends Promise<Make> {
    MakePromise state(State state);

    MakePromise year(int year);

    MakePromise view(View view);
}
