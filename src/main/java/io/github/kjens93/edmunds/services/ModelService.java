package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.ModelPromise;

/**
 * Created by kjensen on 11/23/16.
 */
public interface ModelService {

    ModelPromise findModel(String makeNiceName, String modelNiceName);

}
