package io.github.kjens93.edmunds;

import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * Created by kjensen on 11/23/16.
 */
@Setter
@Accessors(fluent = true, chain = true)
class StylesQueryImpl extends QueryCountableGettableImpl<List<Style>> implements StylesService.Query1, StylesService.Query2 {

    private final EdmundsHttpService httpService;
    private final String urlForGet;
    private final String urlForCount;
    private State state;
    private String submodel;
    private Category category;
    private View view;

    StylesQueryImpl(EdmundsHttpService httpService, String makeNiceName, String modelNiceName, int year) {
        this.httpService = httpService;
        this.urlForGet = String.format("/api/vehicle/v2/%s/%s/%s/styles", makeNiceName, modelNiceName, year);
        this.urlForCount = urlForGet + "/count";
    }

    StylesQueryImpl(EdmundsHttpService httpService, String makeNiceName, String modelNiceName) {
        this.httpService = httpService;
        this.urlForGet = String.format("/api/vehicle/v2/%s/%s/styles", makeNiceName, modelNiceName);
        this.urlForCount = urlForGet + "/count";
    }

    StylesQueryImpl(EdmundsHttpService httpService, String makeNiceName) {
        this.httpService = httpService;
        this.urlForGet = String.format("/api/vehicle/v2/%s/styles", makeNiceName);
        this.urlForCount = urlForGet + "/count";
    }

    StylesQueryImpl(EdmundsHttpService httpService) {
        this.httpService = httpService;
        this.urlForGet = "/api/vehicle/v2/styles";
        this.urlForCount = urlForGet + "/count";
    }

    @Override
    public int count() {
        return httpService.getOne(Styles.class, urlForCount, createParams()).getStylesCount();
    }

    @Override
    public List<Style> get() {
        return httpService.getOne(Styles.class, urlForGet, createParams()).getStyles();
    }

    private Map<String, Object> createParams() {
        return Params.createParams(state, submodel, category, view);
    }

}
