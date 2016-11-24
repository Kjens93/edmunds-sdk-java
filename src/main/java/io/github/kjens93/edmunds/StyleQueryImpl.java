package io.github.kjens93.edmunds;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@RequiredArgsConstructor
@Accessors(fluent = true, chain = true)
class StyleQueryImpl extends QueryGettableImpl<Style> implements StyleService.Query {

    private final EdmundsHttpService httpService;
    private final int id;

    @Override
    public Style get() {
        String path = String.format("/api/vehicle/v2/styles/%s", id);
        return httpService.getOne(Style.class, path, null);
    }

}
