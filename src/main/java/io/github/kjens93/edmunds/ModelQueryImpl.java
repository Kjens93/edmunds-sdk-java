package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

import static io.github.kjens93.edmunds.Params.createParams;
import static io.github.kjens93.edmunds.Verify.verifyNotNull;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class ModelQueryImpl extends QueryGettableImpl<Model> implements ModelService.Query {

    private final EdmundsHttpService httpService;
    private final String makeNiceName;
    private final String modelNiceName;
    private State state;
    private Integer year;
    private View view;
    private String submodel;
    private Category category;

    @Override
    public ModelService.Query year(int year) {
        this.year = year;
        return this;
    }

    @Override
    public Model get() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        verifyNotNull(modelNiceName, new NullPointerException("modelNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/%s", makeNiceName, modelNiceName);
        Map<String, Object> params = createParams(state, year, submodel, category, view);
        return httpService.getOne(Model.class, path, params);
    }
}
