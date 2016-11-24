package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashMap;

import static io.github.kjens93.edmunds.Verify.verifyNotNull;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
@RequiredArgsConstructor
class MakeQueryImpl extends QueryGettableImpl<Make> implements MakeService.Query {

    private final EdmundsHttpService httpService;
    private final String niceName;
    private State state;
    private Integer year;
    private View view;

    @Override
    public MakeService.Query year(int year) {
        this.year = year;
        return this;
    }

    @Override
    public Make get() {
        verifyNotNull(niceName, new NullPointerException("niceName cannot be null"));
        String path = String.format("/api/vehicle/v2/%s", niceName);
        return httpService.getOne(Make.class, path, new HashMap<String, Object>() {{
            put("state", state);
            put("year", year);
            put("view", view);
        }});
    }
}
