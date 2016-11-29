package io.github.kjens93.edmunds;

/**
 * Created by kjensen on 11/20/16.
 */
public class Edmunds implements MakesService, ModelsService, YearsService, StylesService {

    private final EdmundsHttpService httpService = new EdmundsHttpService();

    public Edmunds(String apiKey) {
        httpService.setApiKey(apiKey);
    }

    @Override
    public MakeService.Query findMake(String niceName) {
        return new MakeQueryImpl(httpService, niceName);
    }

    @Override
    public MakesService.Query findAllMakes() {
        return new MakesQueryImpl(httpService);
    }

    @Override
    public ModelService.Query findModel(String makeNiceName, String modelNiceName) {
        return new ModelQueryImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public ModelsService.Query findAllModels(String makeNiceName) {
        return new ModelsQueryImpl(httpService, makeNiceName);
    }

    @Override
    public YearsService.Query findAllModelYears(String makeNiceName, String modelNiceName) {
        return new YearsQueryImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public YearService.Query findModelYear(String makeNiceName, String modelNiceName, int year) {
        return new YearQueryImpl(httpService, makeNiceName, modelNiceName, year);
    }

    @Override
    public StyleService.Query findStyle(int id) {
        return new StyleQueryImpl(httpService, id);
    }

    @Override
    public StylesService.Query1 findStyles(String makeNiceName, String modelNiceName, int year) {
        return new StylesQueryImpl(httpService, makeNiceName, modelNiceName, year);
    }

    @Override
    public StylesService.Query2 findStyles(String makeNiceName, String modelNiceName) {
        return new StylesQueryImpl(httpService, makeNiceName, modelNiceName);
    }

    @Override
    public StylesService.Query2 findStyles(String makeNiceName) {
        return new StylesQueryImpl(httpService, makeNiceName);
    }

    @Override
    public StylesService.Query2 findStyles() {
        return new StylesQueryImpl(httpService);
    }

}
