package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.StylePromise;

/**
 * Created by kjensen on 11/20/16.
 */
public interface StyleService {

    StylePromise findStyle(int id);

}
