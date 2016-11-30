package io.github.kjens93.edmunds.services;

import io.github.kjens93.edmunds.promises.YearPromise;

/**
 * Created by kjensen on 11/23/16.
 */
public interface YearService {

    YearPromise findModelYear(String makeNiceName, String modelNiceName, int year);

}
