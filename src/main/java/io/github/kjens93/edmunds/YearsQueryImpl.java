package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

import static io.github.kjens93.edmunds.Params.createParams;
import static io.github.kjens93.edmunds.Verify.verifyNotNull;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class YearsQueryImpl extends QueryCountableGettableImpl<List<Year>> implements YearsService.Query {

    private final EdmundsHttpService httpService;
    private final String makeNiceName;
    private final String modelNiceName;
    private State state;
    private String submodel;
    private Category category;
    private View view;

    @Override
    public int count() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        verifyNotNull(modelNiceName, new NullPointerException("modelNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/%s/years/count", makeNiceName, modelNiceName);
        Map<String, Object> params = createParams(state, submodel, category, view);
        return httpService.getOne(Years.class, path, params).getYearsCount();
    }

    @Override
    public List<Year> get() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        verifyNotNull(modelNiceName, new NullPointerException("modelNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/%s/years", makeNiceName, modelNiceName);
        Map<String, Object> params = createParams(state, submodel, category, view);
        return httpService.getOne(Years.class, path, params).getYears();
    }

}
