package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.promises.*;
import io.github.kjens93.edmunds.services.MakesService;
import io.github.kjens93.edmunds.services.ModelsService;
import io.github.kjens93.edmunds.services.StylesService;
import io.github.kjens93.edmunds.services.YearsService;

/**
 * Created by kjensen on 11/20/16.
 */
public class Edmunds implements MakesService, ModelsService, YearsService, StylesService {

    private final EdmundsHttpService httpService = new EdmundsHttpService();

    public Edmunds(String apiKey) {
        httpService.setApiKey(apiKey);
    }

    @Override
    public MakePromise findMake(String niceName) {
        return new MakePromiseImpl(httpService, niceName);
    }

    @Override
    public MakesPromise findAllMakes() {
        return new MakesPromiseImpl(httpService);
    }

    @Override
    public ModelPromise findModel(String makeNiceName, String modelNiceName) {
        return new ModelPromiseImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public ModelsPromise findAllModels(String makeNiceName) {
        return new ModelsPromiseImpl(httpService, makeNiceName);
    }

    @Override
    public YearsPromise findAllModelYears(String makeNiceName, String modelNiceName) {
        return new YearsPromiseImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public YearPromise findModelYear(String makeNiceName, String modelNiceName, int year) {
        return new YearPromiseImpl(httpService, makeNiceName, modelNiceName, year);
    }

    @Override
    public StylePromise findStyle(int id) {
        return new StylePromiseImpl(httpService, id);
    }

    @Override
    public StylesPromise findAllStyles(String makeNiceName, String modelNiceName, int year) {
        return new StylesPromiseImpl(httpService, makeNiceName, modelNiceName, year);
    }

    @Override
    public StylesCountPromise findAllStyles(String makeNiceName, String modelNiceName) {
        return new StylesPromiseImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public StylesCountPromise findAllStyles(String makeNiceName) {
        return new StylesPromiseImpl(httpService, makeNiceName);
    }

    @Override
    public StylesCountPromise findAllStyles() {
        return new StylesPromiseImpl(httpService);
    }

}
