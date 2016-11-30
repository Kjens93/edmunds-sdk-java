package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.MakePromise;

/**
 * Created by kjensen on 11/23/16.
 */
public interface MakeService {

    MakePromise findMake(String niceName);

}
