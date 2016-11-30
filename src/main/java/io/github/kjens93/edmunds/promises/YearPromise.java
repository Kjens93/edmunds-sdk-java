package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dtos.Year;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

/**
 * Created by kjensen on 11/29/16.
 */
public interface YearPromise extends Promise<Year> {
    YearPromise state(State state);

    YearPromise submodel(String submodel);

    YearPromise category(Category category);

    YearPromise view(View view);
}
