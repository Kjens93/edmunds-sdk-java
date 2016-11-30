package io.github.kjens93.edmunds.promises;

import io.github.kjens93.edmunds.dto.Style;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.promises.Promise;

import java.util.List;

/**
 * Created by kjensen on 11/29/16.
 */
public interface StylesPromise extends CountablePromise, Promise<List<Style>> {
    StylesPromise state(State state);

    StylesPromise submodel(String submodel);

    StylesPromise category(Category category);

    StylesPromise view(View view);
}
