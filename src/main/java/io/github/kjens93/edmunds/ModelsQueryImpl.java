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
class ModelsQueryImpl extends QueryCountableGettableImpl<List<Model>> implements ModelsService.Query {

    private final EdmundsHttpService httpService;
    private final String makeNiceName;
    private State state;
    private Integer year;
    private View view;
    private String submodel;
    private Category category;

    @Override
    public ModelsService.Query year(int year) {
        this.year = year;
        return this;
    }

    @Override
    public int count() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/models/count", makeNiceName);
        Map<String, Object> params = createParams(state, year, submodel, category, view);
        return httpService.getOne(Models.class, path, params).getModelsCount();
    }

    @Override
    public List<Model> get() {
        verifyNotNull(makeNiceName, new NullPointerException("makeNiceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s/models", makeNiceName);
        Map<String, Object> params = createParams(state, year, submodel, category, view);
        return httpService.getOne(Models.class, path, params).getModels();
    }
}
