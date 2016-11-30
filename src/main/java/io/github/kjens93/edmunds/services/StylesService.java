package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.StylesCountPromise;
import io.github.kjens93.edmunds.promises.StylesPromise;

/**
 * Created by kjensen on 11/20/16.
 */
public interface StylesService extends StyleService {

    StylesPromise findAllStyles(String makeNiceName, String modelNiceName, int year);

    StylesCountPromise findAllStyles(String makeNiceName, String modelNiceName);

    StylesCountPromise findAllStyles(String makeNiceName);

    StylesCountPromise findAllStyles();

}
