package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dtos.Model;
import io.github.kjens93.edmunds.dtos.Models;
import io.github.kjens93.edmunds.enums.Category;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.edmunds.promises.ModelsPromise;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

import static io.github.kjens93.edmunds.utils.Params.createParams;
import static io.github.kjens93.edmunds.utils.Verify.verifyNotNull;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class ModelsPromiseImpl implements ModelsPromise {

    private final EdmundsHttpService httpService;
    private final String makeNiceName;
    private State state;
    private Integer year;
    private View view;
    private String submodel;
    private Category category;

    @Override
    public ModelsPromise year(int year) {
        this.year = year;
        return this;
    }

    @Override
    public int getCount() {
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
