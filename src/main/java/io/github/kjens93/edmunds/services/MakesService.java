package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.MakesPromise;

/**
 * Created by kjensen on 11/20/16.
 */
public interface MakesService extends MakeService {

    MakesPromise findAllMakes();

}
