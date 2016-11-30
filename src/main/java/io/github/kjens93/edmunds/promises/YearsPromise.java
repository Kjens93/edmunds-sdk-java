package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dto.Year;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

import java.util.List;

/**
 * Created by kjensen on 11/29/16.
 */
public interface YearsPromise extends CountablePromise, Promise<List<Year>> {
    YearsPromise state(State state);

    YearsPromise submodel(String submodel);

    YearsPromise category(Category category);

    YearsPromise view(View view);
}
