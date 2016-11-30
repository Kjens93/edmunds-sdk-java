package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.ModelsPromise;

/**
 * Created by kjensen on 11/20/16.
 */
public interface ModelsService extends ModelService {

    ModelsPromise findAllModels(String makeNiceName);

}
