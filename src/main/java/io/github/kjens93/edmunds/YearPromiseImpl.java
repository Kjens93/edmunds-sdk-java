package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.edmunds.dtos.Year;
import io.github.kjens93.edmunds.promises.YearPromise;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

import static io.github.kjens93.edmunds.utils.Params.createParams;
import static io.github.kjens93.edmunds.utils.Verify.verifyNotNull;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class YearPromiseImpl implements YearPromise {

    private final EdmundsHttpService httpService;
    private final String makeNiceName;
    private final String modelNiceName;
    private final int year;
    private State state;
    private String submodel;
    private Category category;
    private View view;

    @Override
    public Year get() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        verifyNotNull(modelNiceName, new NullPointerException("modelNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/%s/%s", makeNiceName, modelNiceName, year);
        Map<String, Object> params = createParams(state, submodel, category, view);
        return httpService.getOne(Year.class, path, params);
    }

}
