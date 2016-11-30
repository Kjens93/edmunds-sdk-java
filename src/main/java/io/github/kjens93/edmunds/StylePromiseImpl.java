package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dtos.Style;
import io.github.kjens93.edmunds.promises.StylePromise;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@RequiredArgsConstructor
@Accessors(fluent = true, chain = true)
class StylePromiseImpl implements StylePromise {

    private final EdmundsHttpService httpService;
    private final int id;

    @Override
    public Style get() {
        String path = String.format("/api/vehicle/v2/styles/%s", id);
        return httpService.getOne(Style.class, path, null);
    }

}
