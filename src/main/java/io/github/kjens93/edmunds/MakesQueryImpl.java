package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

import static io.github.kjens93.edmunds.Params.createParams;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class MakesQueryImpl extends QueryCountableGettableImpl<List<Make>> implements MakesService.Query {

    private final EdmundsHttpService httpService;
    private State state;
    private Integer year;
    private View view;

    @Override
    public MakesService.Query year(int year) {
        this.year = year;
        return this;
    }

    @Override
    public List<Make> get() {
        String path = "/api/vehicle/v2/makes";
        Map<String, Object> params = createParams(state, year, view);
        return httpService.getOne(Makes.class, path, params).getMakes();
    }

    @Override
    public int count() {
        String path = "/api/vehicle/v2/makes/count";
        Map<String, Object> params = createParams(state, year, view);
        return httpService.getOne(Makes.class, path, params).getMakesCount();
    }

}
