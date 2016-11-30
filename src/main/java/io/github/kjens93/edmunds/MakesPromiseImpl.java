package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dto.Make;
import io.github.kjens93.edmunds.dto.Makes;
import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.enums.View;
import io.github.kjens93.edmunds.promises.MakesPromise;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

import static io.github.kjens93.edmunds.utils.Params.createParams;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class MakesPromiseImpl implements MakesPromise {

    private final EdmundsHttpService httpService;
    private State state;
    private Integer year;
    private View view;

    @Override
    public MakesPromise year(int year) {
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
    public int getCount() {
        String path = "/api/vehicle/v2/makes/count";
        Map<String, Object> params = createParams(state, year, view);
        return httpService.getOne(Makes.class, path, params).getMakesCount();
    }

}
